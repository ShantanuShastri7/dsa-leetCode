class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0; 
        int j=nums.length-1;
        int result = j+1;

        while(i<=j){
            int num = (i+j)/2;

            if(nums[num]>=target) {
                result=num;
                j=num-1;
            }
            else if(nums[num]<target) i=num+1;
        }

        return result;
    }
}