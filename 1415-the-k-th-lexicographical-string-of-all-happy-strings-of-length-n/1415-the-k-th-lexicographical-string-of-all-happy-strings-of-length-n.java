class Solution {
    List<String> res = new ArrayList<>();

    public String getHappyString(int n, int k) {
        generate("", n);
        if (k > res.size()) return "";
        return res.get(k - 1);
    }

    void generate(String s, int n) {
        if (s.length() == n) {
            res.add(s);
            return;
        }

        for (char c : new char[]{'a','b','c'}) {
            if (s.length() == 0 || s.charAt(s.length()-1) != c) {
                generate(s + c, n);
            }
        }
    }
}