class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] height = new int[cols];
        int maxArea = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0)
                    height[c] = 0;
                else
                    height[c] = height[c] + 1;
            }
            int[] sorted = height.clone();
            Arrays.sort(sorted);

            for (int i = 0; i < cols; i++) {
                int area = sorted[i] * (cols - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}