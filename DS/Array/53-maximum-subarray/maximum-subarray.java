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