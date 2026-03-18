class Solution {
    public long countCommas(long n) {
        if (n < 1000) return 0;
        long count = 0;
        count += n - 999;
        if (n >= 1_000_000) {
            count += n - 999_999;
        }
        if (n >= 1_000_000_000) {
            count += n - 999_999_999;
        }
        return count;
    }
}