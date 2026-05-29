class Solution {
    public int search(int[] nums, int target) {
        int i=0; 
        int j=nums.length-1;

        while(i<=j){
            int num = (i+j)/2;
            boolean leftSorted = nums[num]>=nums[i];
            boolean rightSorted = nums[j]>=nums[num];

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