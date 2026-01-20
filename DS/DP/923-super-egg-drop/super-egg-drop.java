class Solution {
    public int superEggDrop(int k, int n) {
        // dp[m][e] = max floors testable with m moves and e eggs
        int[][] dp = new int[n + 1][k + 1];

        int moves = 0;

        // Increase moves until we can cover n floors
        while (dp[moves][k] < n) {
            moves++;

            for (int e = 1; e <= k; e++) {
                dp[moves][e] =
                        dp[moves - 1][e - 1] +
                        dp[moves - 1][e] +
                        1;
            }
        }

        return moves;
    }
}
