class Solution {
    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = t.length(); j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }

        return dp[t.length()];
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