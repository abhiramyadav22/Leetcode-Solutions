class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int t = 0; t < 4; t++) {
            if (equal(mat, target)) return true;
            mat = rotate(mat);
        }
        return false;
    }

    int[][] rotate(int[][] a) {
        int n = a.length;
        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                b[j][n - 1 - i] = a[i][j];
        return b;
    }

    boolean equal(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] != b[i][j]) return false;
        return true;
    }
}