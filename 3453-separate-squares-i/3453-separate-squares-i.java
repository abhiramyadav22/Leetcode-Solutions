class Solution {
    public double separateSquares(int[][] squares) {
        double total = 0, low = 1e18, high = 0;

        for (int[] s : squares) {
            double y = s[1], l = s[2];
            total += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2;
            double area = 0;

            for (int[] s : squares) {
                double y = s[1], l = s[2];
                area += l * Math.min(l, Math.max(0, mid - y));
            }

            if (area * 2 >= total) high = mid;
            else low = mid;
        }

        return high;
    }
}
