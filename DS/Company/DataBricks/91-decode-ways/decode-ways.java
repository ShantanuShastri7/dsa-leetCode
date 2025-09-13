class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return helper(s, s.length() - 1, dp);
    }

    private int helper(String s, int index, int[] dp) {
        if (index <= 0) return 1;

        if(dp[index]!=-1) return dp[index];

        int count = 0;

        if (s.charAt(index) != '0') {
            count += helper(s, index - 1, dp);
        }

        int twoDigit = (s.charAt(index - 1) - '0') * 10 + (s.charAt(index) - '0');
        if (twoDigit >= 10 && twoDigit <= 26) {
            count += helper(s, index - 2, dp);
        }

        return dp[index] = count;
    }
}
