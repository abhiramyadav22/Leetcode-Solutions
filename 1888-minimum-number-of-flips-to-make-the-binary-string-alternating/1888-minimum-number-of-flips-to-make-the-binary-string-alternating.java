class Solution {
    public int minFlips(String s) {

        int n = s.length();
        s = s + s;
        int flip1 = 0, flip2 = 0, ans = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != (i % 2 == 0 ? '0' : '1')) flip1++;
            if (s.charAt(i) != (i % 2 == 0 ? '1' : '0')) flip2++;
            if (i >= n) {
     if (s.charAt(i - n) != ((i - n) % 2 == 0 ? '0' : '1')) flip1--;  
     if (s.charAt(i - n) != ((i - n) % 2 == 0 ? '1' : '0')) flip2--;
            }
            if (i >= n - 1) {
                ans = Math.min(ans, Math.min(flip1, flip2));
            }
        }
        return ans;
    }
}