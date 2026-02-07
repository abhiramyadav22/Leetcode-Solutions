class Solution {
    public int minimumDeletions(String s) {
        int ans = 0, b = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'b')
                b++;
            else if (b > 0) {
                ans++;
                b--;
            }
        }

        return ans;
    }
}
