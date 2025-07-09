class Solution {
    public int minDistance(String word1, String word2) {
        int[] prev = new int[word2.length()+1];

        for (int i = 0; i <= word2.length(); i++) {
            prev[i] = 0;
        }
        for (int i = 1; i <= word1.length(); i++) {
            int[] cur = new int[word2.length()+1];
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    cur[j] = 1 + prev[j - 1];
                } else {
                    cur[j] = Math.max(cur[j - 1],
                            prev[j]);
                }
            }
            prev=cur;
        }
        
        return word1.length()+word2.length()-2*prev[word2.length()];
        
    }
}