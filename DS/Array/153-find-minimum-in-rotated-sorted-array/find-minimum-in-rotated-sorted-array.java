class Solution {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private int helper(int[] nums, int start, int end){
        if(end-start<=1) return nums[start]<nums[end]?nums[start]:nums[end];

        boolean isLeftSorted=false;
        boolean isRightSorted=false;

        int mid = (start+end+1)/2;

        if(nums[mid]>=nums[start]) isLeftSorted=true;
        if(nums[end]>=nums[mid]) isRightSorted=true;

        if(isLeftSorted && isRightSorted) return nums[start];

        if(isLeftSorted) return helper(nums, mid, end);
        else return helper(nums, start, mid);

    }
}