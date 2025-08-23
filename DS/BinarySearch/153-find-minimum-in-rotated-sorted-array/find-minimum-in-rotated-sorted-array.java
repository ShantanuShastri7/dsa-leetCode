class Solution {
    public int findMin(int[] nums) {
        int i=0; 
        int j=nums.length - 1;
        int result=Integer.MAX_VALUE;

        while(i<=j){
            boolean leftSorted=false;
            boolean rightSorted=false;
            int num = (i+j)/2;

            if(nums[num]>=nums[i]) leftSorted=true;
            if(nums[num]<=nums[j]) rightSorted=true;

            if(leftSorted && rightSorted){
                return nums[i]<result?nums[i]:result;
            } else if(leftSorted) {
                i=num+1;
                if(nums[i]<result) result=nums[i];
            } else {
                if(nums[num]<result) result=nums[num];
                j=num-1;
            }
        }
        return result;
    }
}