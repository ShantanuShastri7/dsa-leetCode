class Solution {
    public int search(int[] nums, int target) {
        int i=0; 
        int j=nums.length-1;

        while(i<=j){
            int num = (i+j)/2;

            if(nums[num]==target) return num;
            else if(nums[num]<target) i=num+1;
            else j=num-1;
        }
        return -1;
    }
}