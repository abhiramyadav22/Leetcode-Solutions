class Solution {
    public int smallestBalancedIndex(int[] nums) {
        long lsum = 0;
        for (int x : nums) lsum += x;

        long rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            lsum -= nums[i];  
            if (lsum == rightProduct) 
                return i;
            if (rightProduct > lsum / nums[i])  
                break;
            rightProduct *= nums[i];  
        }

        return -1;
    }
}