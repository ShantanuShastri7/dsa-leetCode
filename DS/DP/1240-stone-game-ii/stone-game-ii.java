class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        
        // Step 3: Precompute suffix sums
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        return helper(piles, dp, suffixSum, 0, 1);
    }

    private int helper(int[] piles, int[][] dp, int[] suffixSum, int index, int m) {
        // Base case: No stones left
        if (index >= piles.length) return 0;
        
        // Step 4: Return cached result
        if (dp[index][m] != 0) return dp[index][m];

        // Optimization: If the current player can take all remaining stones, take them!
        if (index + 2 * m >= piles.length) {
            return suffixSum[index];
        }

        int minOpponentScore = Integer.MAX_VALUE;

        // Step 2: The current player tries all their valid moves (i)
        for (int i = 1; i <= 2 * m; i++) {
            
            // The opponent will play optimally from the new index with the new M
            int opponentScore = helper(piles, dp, suffixSum, index + i, Math.max(m, i));
            
            // We want to leave the opponent with the SMALLEST possible score
            minOpponentScore = Math.min(minOpponentScore, opponentScore);
        }

        // My Max Score = (All remaining stones) - (The least I can force the opponent to take)
        dp[index][m] = suffixSum[index] - minOpponentScore;
        
        return dp[index][m];
    }
}