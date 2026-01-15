class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];

        for(int i=0; i<text1.length(); i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(text1, text2, 0, 0, dp);
    }

    private int helper(String text1, String text2, int index1, int index2, int[][] dp){
        if(index1>=text1.length() || index2>=text2.length()){
            return 0;
        }
        
        if(dp[index1][index2]!=-1) return dp[index1][index2];

        int notPick = helper(text1, text2, index1+1, index2, dp);
        int notPick2 = helper(text1, text2, index1, index2+1, dp);
        int pick=0;
        if(text1.charAt(index1)==text2.charAt(index2)){
            pick = 1+ helper(text1, text2, index1+1, index2+1, dp);
        }

        return dp[index1][index2] = Math.max(Math.max(notPick, notPick2), pick);
    }
}














// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int[] prev = new int[text2.length()+1];

//         for (int i = 0; i <= text2.length(); i++) {
//             prev[i] = 0;
//         }
//         for (int i = 1; i <= text1.length(); i++) {
//             int[] cur = new int[text2.length()+1];
//             for (int j = 1; j <= text2.length(); j++) {
//                 if (text1.charAt(i-1) == text2.charAt(j-1)) {
//                     cur[j] = 1 + prev[j - 1];
//                 } else {
//                     cur[j] = Math.max(cur[j - 1],
//                             prev[j]);
//                 }
//             }
//             prev=cur;
//         }

//         return prev[text2.length()];
//     }

//     public int longestCommonSubsequence(String text1, String text2) {
//         int[][] dp = new int[text1.length()+1][text2.length()+1];

//         for (int i = 0; i <= text1.length(); i++) {
//             dp[i][0] = 0;
//         }
//         for (int i = 0; i <= text2.length(); i++) {
//             dp[0][i] = 0;
//         }
//         for (int i = 1; i <= text1.length(); i++) {
//             for (int j = 1; j <= text2.length(); j++) {
//                 if (text1.charAt(i-1) == text2.charAt(j-1)) {
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 } else {
//                     dp[i][j] = Math.max(dp[i][j - 1],
//                             dp[i - 1][j]);
//                 }
//             }
//         }

//         return dp[text1.length()][text2.length()];
//     }

//     private int helper(String text1, String text2, int index1, int index2, int[][] dp) {
//         if (index1 < 0 || index2 < 0)
//             return 0;

//         if (dp[index1][index2] != -1)
//             return dp[index1][index2];

//         if (text1.charAt(index1) == text2.charAt(index2)) {
//             return dp[index1][index2] = 1 + helper(text1, text2, index1 - 1, index2 - 1, dp);
//         } else {
//             return dp[index1][index2] = Math.max(helper(text1, text2, index1, index2 - 1, dp),
//                     helper(text1, text2, index1 - 1, index2, dp));
//         }
//     }
// }