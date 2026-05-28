class Solution {
    public int maxProduct(int[] nums) {
        int runningMax = nums[0];
        int runningMin = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            // Calculate all three candidates
            int cand1 = current;
            int cand2 = runningMax * current;
            int cand3 = runningMin * current;

            // Update runningMax and runningMin simultaneously
            runningMax = Math.max(cand1, Math.max(cand2, cand3));
            runningMin = Math.min(cand1, Math.min(cand2, cand3));

            // Update the global result
            result = Math.max(result, runningMax);
        }

        return result;
    }
}