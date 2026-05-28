class Solution {
    public int maxSubArray(int[] nums) {
        long sum = 0; 
        long max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            max=Math.max(max, sum);

            if(sum<0) sum=0;
        }

        return (int) max;
    }
}