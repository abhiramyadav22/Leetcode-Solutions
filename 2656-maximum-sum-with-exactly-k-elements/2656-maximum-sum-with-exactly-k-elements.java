class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int i : nums)
            max = Math.max(max, i);
        int ans = max;
        while (k > 1) {
            ans += ++max;
            k--;
        }
        return ans;
    }
}