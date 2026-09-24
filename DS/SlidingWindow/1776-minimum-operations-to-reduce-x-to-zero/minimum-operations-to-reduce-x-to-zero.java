class Solution {
    public int minOperations(int[] nums, int x) {
        int numsSum = Arrays.stream(nums).sum();

        int midSum = numsSum - x;

        if(midSum<0) return -1;

        int size = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int sum = 0;
        for (j = 0; j < nums.length; j++) {
            sum += nums[j];

            if (sum < midSum)
                continue;

            while (i<nums.length && sum > midSum) {
                sum -= nums[i];
                i++;
            }

            if (sum == midSum) {
                size = Math.min(size, nums.length - (j - i + 1));
            }
        }

        return size==Integer.MAX_VALUE?-1:size;
    }

    //This did not work out, even after memoization space complexity will give MLE
    private int helper(int[] nums, int leftIndex, int rightIndex, int remaining) {
        if (remaining == 0) {
            int ops = leftIndex + (nums.length - rightIndex - 1);
            return ops;
        }
        if (remaining < 0)
            return Integer.MAX_VALUE;
        if (leftIndex > rightIndex)
            return Integer.MAX_VALUE;

        int leftOps = helper(nums, leftIndex + 1, rightIndex, remaining - nums[leftIndex]);

        int rightOps = helper(nums, leftIndex, rightIndex - 1, remaining - nums[rightIndex]);

        return Math.min(leftOps, rightOps);
    }
}