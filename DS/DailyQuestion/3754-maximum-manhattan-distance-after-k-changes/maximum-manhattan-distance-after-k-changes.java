class Solution {
    public int maxDistance(String s, int k) {
        return Math.max(
            Math.max(helper(s,'N','E',k),helper(s,'N','W',k)),
            Math.max(helper(s,'S','E',k),helper(s,'S','W',k))
            );
    }

    private int helper (String s, char a, char b, int k){
        int pos = 0, used = 0, maxDist = 0;
        for (char c : s.toCharArray()) {
            if (c == a || c == b) {
                pos++;
            } else if (used < k) {
                pos--;
                used++;
            } else {
                pos--;
            }
            maxDist = Math.max(maxDist, pos + 2 * Math.min(k, used));
        }
        return maxDist;
    }
}