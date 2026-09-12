class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int begin = n / 2;
        
        // Use long just in case the array contains massive numbers
        long sum = 0;
        long halfSum = 0;

        // 1. Calculate the total sum AND the initial second half sum simultaneously
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= begin) {
                halfSum += nums[i];
            }
        }

        int res = 0;
        
        // 2. Check the initial, unrotated array (Rotation 0)
        if (sum - halfSum > halfSum) {
            res++;
        }

        // 3. Slide the window for the remaining rotations!
        for (int i = 0; i < n - 1; i++) {
            halfSum = halfSum + nums[i] - nums[begin];
            
            if (sum - halfSum > halfSum) {
                res++;
            }
            
            begin = (begin + 1) % n;
        }

        return res;
    }
}