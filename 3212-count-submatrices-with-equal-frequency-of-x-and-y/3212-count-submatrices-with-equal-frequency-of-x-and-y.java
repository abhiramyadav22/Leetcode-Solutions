class Solution {
    public int numberOfSubmatrices(char[][] g) {
        int m = g.length, n = g[0].length, ans = 0;
        int[][] x = new int[m][n], y = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = g[i][j] == 'X' ? 1 : 0;
                y[i][j] = g[i][j] == 'Y' ? 1 : 0;

                if (i > 0) {
                    x[i][j] += x[i - 1][j];
                    y[i][j] += y[i - 1][j];
                }
                if (j > 0) {
                    x[i][j] += x[i][j - 1];
                    y[i][j] += y[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    x[i][j] -= x[i - 1][j - 1];
                    y[i][j] -= y[i - 1][j - 1];
                }

                if (x[i][j] == y[i][j] && x[i][j] > 0) ans++;
            }
        }
        return ans;
    }
}