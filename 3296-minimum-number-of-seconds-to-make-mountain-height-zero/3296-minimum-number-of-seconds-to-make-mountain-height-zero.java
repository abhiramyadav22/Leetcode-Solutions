class Solution {
    public long minNumberOfSeconds(int h, int[] w) {
        long l = 0, r = (long)1e18;
        while (l < r) {
            long mid = (l + r) / 2;
            long total = 0;
            for (int t : w) {
                long x = (long)((Math.sqrt(1 + 8.0 * mid / t) - 1) / 2);
                total += x;
            }
            if (total >= h) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}