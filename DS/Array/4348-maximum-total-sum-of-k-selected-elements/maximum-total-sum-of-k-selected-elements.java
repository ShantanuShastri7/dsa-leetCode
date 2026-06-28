import java.util.Arrays;

class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        
        long totalSum = 0;
        int n = nums.length;
        
        for (int i = 0; i < k; i++) {
            long currentNum = nums[n - 1 - i];
            
            long optionAdd = currentNum;
            long optionMultiply = currentNum * mul;
            
            totalSum += Math.max(optionAdd, optionMultiply);
            
            mul--;
        }
        
        return totalSum;
    }
}