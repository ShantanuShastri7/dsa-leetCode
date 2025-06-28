class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
//
        int[] memo1 = new int[n];
        Arrays.fill(memo1, -1);
        int max1 = helper(nums, 0, n - 2, memo1);

        int[] memo2 = new int[n];
        Arrays.fill(memo2, -1);
        int max2 = helper(nums, 1, n - 1, memo2);

        return Math.max(max1, max2);
    }

    private int helper(int[] nums, int start, int end, int[] memo) {
        if (start > end) return 0;
        if (memo[start] != -1) return memo[start];

        int pick = nums[start] + helper(nums, start + 2, end, memo);
        int notPick = helper(nums, start + 1, end, memo);

        return memo[start] = Math.max(pick, notPick);
    }
}
