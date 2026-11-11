class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        // We start at step 0
        return helper(costs, 0, n, dp);
    }

    private int helper(int[] costs, int i, int n, int[] dp) {
        // Base case: If we are already at the top, the remaining cost is 0
        if (i == n) {
            return 0;
        }

        // Return the cached result if we've already calculated the cost from step i
        if (dp[i] != -1) {
            return dp[i];
        }

        int minCost = Integer.MAX_VALUE;

        // Option 1: Jump 1 step to i + 1
        if (i + 1 <= n) {
            int next = helper(costs, i + 1, n, dp);
            if (next != Integer.MAX_VALUE) {
                // Cost = cost of landing on step (i+1) + 1^2 + cost to finish
                minCost = Math.min(minCost, costs[(i + 1) - 1] + 1 + next);
            }
        }

        // Option 2: Jump 2 steps to i + 2
        if (i + 2 <= n) {
            int next = helper(costs, i + 2, n, dp);
            if (next != Integer.MAX_VALUE) {
                // Cost = cost of landing on step (i+2) + 2^2 + cost to finish
                minCost = Math.min(minCost, costs[(i + 2) - 1] + 4 + next);
            }
        }

        // Option 3: Jump 3 steps to i + 3
        if (i + 3 <= n) {
            int next = helper(costs, i + 3, n, dp);
            if (next != Integer.MAX_VALUE) {
                // Cost = cost of landing on step (i+3) + 3^2 + cost to finish
                minCost = Math.min(minCost, costs[(i + 3) - 1] + 9 + next);
            }
        }

        // Cache the result for this step and return it
        return dp[i] = minCost;
    }
}