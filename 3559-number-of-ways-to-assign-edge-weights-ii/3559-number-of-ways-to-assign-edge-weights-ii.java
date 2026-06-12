import java.util.*;

class Solution {
    static final int MOD = 1000000007;
    static final int LOG = 17;

    List<Integer>[] g;
    int[][] up;
    int[] dep;
    long[] pow;
    
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        g = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        up = new int[LOG][n + 1];
        dep = new int[n + 1];
        dfs(1, 0);
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                if (up[j - 1][i] != 0)
                    up[j][i] = up[j - 1][up[j - 1][i]];
            }
        }
        pow = new long[n + 1];
        pow[0] = 1;
        for (int i = 1; i <= n; i++)
            pow[i] = (pow[i - 1] * 2) % MOD;
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            int l = lca(u, v);
            int d = dep[u] + dep[v] - 2 * dep[l];

            ans[i] = d == 0 ? 0 : (int) pow[d - 1];
        }
        return ans;
    }
    void dfs(int u, int p) {
        up[0][u] = p;
        for (int v : g[u]) {
            if (v != p) {
                dep[v] = dep[u] + 1;
                dfs(v, u);
            }
        }
    }
    int lca(int a, int b) {
        if (dep[a] < dep[b]) {
            int t = a;
            a = b;
            b = t;
        }
        int d = dep[a] - dep[b];
        for (int i = 0; i < LOG; i++) {
            if (((d >> i) & 1) == 1)
                a = up[i][a];
        }
        if (a == b) return a;
        for (int i = LOG - 1; i >= 0; i--) {
            if (up[i][a] != up[i][b]) {
                a = up[i][a];
                b = up[i][b];
            }
        }
        return up[0][a];
    }
}