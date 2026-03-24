class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length, mod = 12345;
        int size = m * n;
        int[] arr = new int[size];
        long[] pre = new long[size];
        int[][] res = new int[m][n];

        int k = 0;
        for (int[] r : grid)
            for (int v : r)
                arr[k++] = v;

        pre[0] = 1;
        for (int i = 1; i < size; i++)
            pre[i] = (pre[i - 1] * arr[i - 1]) % mod;

        long suf = 1;
        for (int i = size - 1; i >= 0; i--) {
            res[i / n][i % n] = (int)((pre[i] * suf) % mod);
            suf = (suf * arr[i]) % mod;
        }

        return res;
    }
}