class Solution {
    public int minOperations(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int num : nums) {

            // 1. Build the "menu" of choices for THIS number
            // We can use a simple List of int arrays: {value, cost}
            List<int[]> menu = new ArrayList<>();

            int x = num;
            int ops = 0;
            while (x > 0) {
                if (x <= sum)
                    menu.add(new int[] { x, ops });
                x = x / 2;
                ops++;
            }

            x = num * 2; // Start from *2 to avoid adding the original number twice
            ops = 1;
            while (x <= sum) {
                menu.add(new int[] { x, ops });
                x = x * 2;
                ops++;
            }

            // 2. Take a snapshot of the current DP state
            int[] nextDp = dp.clone();

            // 3. Try every option in our menu against the snapshot
            for (int j = 0; j <= sum; j++) {
                // If we previously reached this sum...
                if (dp[j] != Integer.MAX_VALUE) {

                    // ...try adding every variation of our current number to it!
                    for (int[] option : menu) {
                        int val = option[0];
                        int cost = option[1];

                        if (j + val <= sum) {
                            // Update our NEW board with the minimum cost
                            nextDp[j + val] = Math.min(nextDp[j + val], dp[j] + cost);
                        }
                    }
                }
            }

            // 4. Commit the new board for the next original number to use
            dp = nextDp;
        }

        return dp[dp.length-1]==Integer.MAX_VALUE?-1:dp[dp.length-1];
    }
}