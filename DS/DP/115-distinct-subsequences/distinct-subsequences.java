class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= t.length(); j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }

    private int helper(String s, String t, int i, int j, int dp[][]){
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] = helper(s, t, i-1, j-1, dp) + helper(s, t, i-1, j, dp);
        }
    
        return dp[i][j] = helper(s, t, i-1, j, dp);
    }
}