class Solution {
    public boolean isTrionic(int[] nums) {
        int firstPeak=-9999;
        int firstPeakIndex=0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]>firstPeak){
                firstPeak=nums[i];
                firstPeakIndex=i;
            }else break;
        }

        if(firstPeakIndex==0) return false;

        int lastValley = 9999;
        int lastValleyIndex=nums.length;

        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]<lastValley){
                lastValley=nums[i];
                lastValleyIndex=i;
            } else {
                break;
            }
        }

        if(lastValleyIndex==nums.length-1) return false;

        if(firstPeakIndex>=lastValleyIndex) return false;

        int truth = nums[firstPeakIndex];
        for(int i=firstPeakIndex+1; i<=lastValleyIndex; i++){
            if(nums[i]<truth){
                truth = nums[i];
            } else return false;
        }

        return true;
    }
}