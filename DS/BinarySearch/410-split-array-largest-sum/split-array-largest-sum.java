class Solution {
    public int splitArray(int[] nums, int k) {
        int i = Arrays.stream(nums).max().getAsInt();
        int j = Arrays.stream(nums).sum();
        int result=0;

        while(i<=j){
            int mid = (i+j)/2;
            boolean canBeDone = canThisSumBeMade(nums, mid, k);

            if(canBeDone){
                result=mid;
                j=mid-1;
            } else {
                i=mid+1;
            }
        }
        return result;
    }

    private boolean canThisSumBeMade(int[] nums, int largestSum, int allowedSubArrays){
        int sum=0;
        int subArrays=1;

        for(int i=0; i<nums.length; i++){
            if(sum + nums[i]>largestSum) {
                subArrays++;
                sum=nums[i];
            } else sum+=nums[i];

            if(subArrays>allowedSubArrays) return false;
        }

        return subArrays<=allowedSubArrays;
    }
}