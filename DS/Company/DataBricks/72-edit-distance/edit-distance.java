class Solution {
    public int minDistance(String word1, String word2) {
        if(word1==word2) return 0;

        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for(int i=0; i<=word2.length(); i++) dp[0][i] = i;
        for(int i=0; i<=word1.length(); i++) dp[i][0] = i;

        for(int i=1; i<=word1.length(); i++){
            for(int j=1; j<=word2.length(); j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    int delete = 1 + dp[i-1][j];
                    int insert = 1 + dp[i][j-1];
                    int replace = 1 + dp[i-1][j-1];

                    dp[i][j] = Math.min(delete, Math.min(insert, replace));
                }
            }
        }

        return dp[word1.length()][word2.length()]; 
    }

    //Memoization
    // public int minDistance(String word1, String word2) {
    //     if(word1==word2) return 0;

    //     int[][] dp = new int[word1.length()][word2.length()];

    //     for(int i=0; i<word1.length(); i++) Arrays.fill(dp[i], -1);

    //     return helper(word1, word2, word1.length()-1, word2.length()-1, dp);
    // }

    private int helper(String word1, String word2, int i, int j, int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=-1) return dp[i][j];

        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j] = helper(word1, word2, i-1, j-1, dp);
        } else{
            int delete = 1 + helper(word1, word2, i-1, j, dp);
            int insert = 1 + helper(word1, word2, i, j-1, dp);
            int replace = 1 + helper(word1, word2, i-1, j-1, dp);

            return dp[i][j] = Math.min(delete, Math.min(insert, replace));
        }
    }
}