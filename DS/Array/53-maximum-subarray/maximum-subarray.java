class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize maxSoFar and maxEndingHere to the first element
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Either start a new subarray at nums[i] or extend the previous subarray
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);

            // Update the global maximum
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}





// class Solution {
//     public int maxSubArray(int[] nums) {
//         int[] memo = new int[nums.length];
//         Arrays.fill(memo, Integer.MIN_VALUE);

//         int max = nums[0];
//         for (int i = 0; i < nums.length; i++) {
//             //Trying to find the max sub array ending at i
//             max = Math.max(max, helper(nums, i, memo));
//         }
//         return max;
//     }

//     private int helper(int[] nums, int i, int[] memo) {
//         //if i==0 there can be only that number
//         if (i == 0) return nums[0];
//         if (memo[i] != Integer.MIN_VALUE) return memo[i];

//         //essentially checking if the max is the number or the number plus max from previous
//         //options
//         memo[i] = Math.max(nums[i], nums[i] + helper(nums, i - 1, memo));
//         return memo[i];
//     }
// }


// class Solution {
//     public int maxSubArray(int[] nums) {
//         int n = nums.length;
//         int[] prefix = new int[n + 1];
//         prefix[0] = 0;

//         for (int i = 0; i < n; i++) {
//             prefix[i + 1] = prefix[i] + nums[i];
//         }

//         int minPrefix = 0; // minimum prefix sum seen so far
//         int maxSum = Integer.MIN_VALUE;

//         for (int i = 1; i <= n; i++) {
//             maxSum = Math.max(maxSum, prefix[i] - minPrefix);
//             minPrefix = Math.min(minPrefix, prefix[i]);
//         }

//         return maxSum;
//     }
// }