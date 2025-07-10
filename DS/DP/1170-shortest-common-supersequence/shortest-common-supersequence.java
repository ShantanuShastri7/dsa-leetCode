class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for (int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= text2.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1],
                            dp[i - 1][j]);
                }
            }
        }

        int i=text1.length(); int j=text2.length();
        StringBuilder str = new StringBuilder();

        while(i>0 && j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                str.append(text1.charAt(i-1));
                i--; j--;
            } else if(dp[i][j-1]>dp[i-1][j]){
                str.append(text2.charAt(j-1));
                j--;
            } else{
                str.append(text1.charAt(i-1));
                i--;
            }
        }

        while(i>0){
            str.append(text1.charAt(i-1));
            i--;
        }
        while(j>0){
            str.append(text2.charAt(j-1));
            j--;
        }

        return str.reverse().toString();
    }
}