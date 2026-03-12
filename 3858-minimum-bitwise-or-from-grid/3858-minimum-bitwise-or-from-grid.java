class Solution {
    public int minimumOR(int[][] grid) {
        int ans = 0, bits = 0;

        for (int i = 17; i >= 0; i--) {
            int newBits = bits | (1 << i);
            boolean ok = true;

            for (int[] row : grid) {
                boolean found = false;
                for (int x : row)
                    if ((x & newBits) == 0) { found = true; break; }
                if (!found) { ok = false; break; }
            }

            if (ok) bits = newBits;
            else ans |= (1 << i);
        }

        return ans;
    }
}