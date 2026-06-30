class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] Lastseen = {-1, -1, -1};
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Lastseen[s.charAt(i) - 'a'] = i;
            if (Lastseen[0] != -1 && Lastseen[1] != -1 && Lastseen[2] != -1) {
                cnt = cnt + (1 + Math.min(Lastseen[0], Math.min(Lastseen[1], Lastseen[2])));
            }
        }
        return cnt;
    }
}
