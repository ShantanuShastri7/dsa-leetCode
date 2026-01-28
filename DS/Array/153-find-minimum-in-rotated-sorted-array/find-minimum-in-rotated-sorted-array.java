class Solution {
    public int findMin(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int result = Integer.MAX_VALUE;

        while(i<=j){
            int mid = (i+j)/2;

            boolean leftSorted = false;
            boolean rightSorted = false;

            if(nums[i]<=nums[mid]) leftSorted=true;
            if(nums[mid]<=nums[j]) rightSorted=true;

            if(leftSorted&&rightSorted){
                result=Math.min(result, nums[i]);
                break;
            } else if(leftSorted){
                result=Math.min(result, nums[i]);
                i=mid+1;
            } else{
                result=Math.min(result, nums[mid]);
                j=mid-1;
            }

        }

        return result;
    }
}