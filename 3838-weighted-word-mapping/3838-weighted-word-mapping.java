class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String ans = "";
        for (String word : words) {
            int sum = 0;
            for (char ch : word.toCharArray()) {
                sum += weights[ch - 'a'];
            }
            ans += (char)('z' - (sum % 26));
        }
        return ans;
    }
}