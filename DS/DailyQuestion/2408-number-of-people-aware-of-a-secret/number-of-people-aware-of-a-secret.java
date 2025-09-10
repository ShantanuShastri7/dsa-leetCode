class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;
        int share = 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            if (i - delay > 0) {
                share = (share + dp[i - delay]) % MOD;
            }

            if (i - forget > 0) {
                share = (share - dp[i - forget] + MOD) % MOD; 
            }

            dp[i] = share;
        }

        int total = 0;
        for (int i = Math.max(1, n - forget + 1); i <= n; i++) {
            total = (total + dp[i]) % MOD;
        }

        return total;
    }
}