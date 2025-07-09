class Solution {
    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        int[] prev = new int[reversed.length()+1];

        for (int i = 0; i <= reversed.length(); i++) {
            prev[i] = 0;
        }
        for (int i = 1; i <= s.length(); i++) {
            int[] cur = new int[reversed.length()+1];
            for (int j = 1; j <= reversed.length(); j++) {
                if (s.charAt(i-1) == reversed.charAt(j-1)) {
                    cur[j] = 1 + prev[j - 1];
                } else {
                    cur[j] = Math.max(cur[j - 1],
                            prev[j]);
                }
            }
            prev=cur;
        }
        
        return prev[reversed.length()];
    }
}