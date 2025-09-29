class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int minPrefix = 0; // minimum prefix sum seen so far
        int maxSum = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            maxSum = Math.max(maxSum, prefix[i] - minPrefix);
            minPrefix = Math.min(minPrefix, prefix[i]);
        }

        return maxSum;
    }
}