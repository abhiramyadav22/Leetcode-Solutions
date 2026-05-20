class Solution {
    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            int rev = x % 10;
            ans = ans * 10 + rev;
            x = x / 10;
        }
        return (ans>Integer.MAX_VALUE||ans<Integer.MIN_VALUE)?0:(int) ans;
    }
}