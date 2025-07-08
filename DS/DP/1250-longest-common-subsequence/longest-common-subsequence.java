class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0; i<text1.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(text1,text2, text1.length()-1, text2.length()-1, dp);
    }

    private int helper(String text1, String text2, int index1, int index2, int[][] dp){
        if(index1<0 || index2<0) return 0;

        if(dp[index1][index2]!=-1) return dp[index1][index2];
        if(text1.charAt(index1)==text2.charAt(index2)){
            return dp[index1][index2]=1+ helper(text1, text2, index1-1, index2-1, dp);
        } else{
            return dp[index1][index2]=Math.max(helper(text1, text2, index1, index2-1,dp),helper(text1, text2, index1-1, index2,dp));
        }
    }
}