class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] st = new int[256];
        int[] tt = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // If their last recorded positions don't match, the pattern is broken
            if (st[sChar] != tt[tChar]) {
                return false;
            }

            // Record the current position (+1 because default array value is 0)
            st[sChar] = i + 1;
            tt[tChar] = i + 1;
        }

        return true;
    }
}