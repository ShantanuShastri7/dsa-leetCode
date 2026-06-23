class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        // Use long to prevent integer overflow
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];

        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                long sum = (i == 0) ? prefixSum[j] : prefixSum[j] - prefixSum[i-1];
                
                // Check conditions
                if(sum % 10 == x && helper(sum, x)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean helper(long sum, int x){
        sum = Math.abs(sum);
        
        if (sum < 10) return sum == x;
        
        while(sum >= 10){
            sum /= 10;
        }
        return sum == x;
    }
}