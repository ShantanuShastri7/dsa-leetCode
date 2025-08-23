class Solution {
    public int search(int[] nums, int target) {
        int i=0; 
        int j=nums.length-1;

        while(i<=j){
            boolean leftSorted=false;
            boolean rightSorted=false;
            int num = (i+j)/2;
            if(nums[num]<=nums[j]) rightSorted=true;
            if(nums[num]>=nums[i]) leftSorted=true;

            if(nums[num]==target) return num;
            else if(leftSorted){
                if(nums[i]<=target && target<=nums[num]) j=num-1;
                else i=num+1;
            } else {
                if(nums[num]<=target && target<=nums[j]) i=num+1;
                else j=num-1;
            }
        }

        return -1;
    }
}