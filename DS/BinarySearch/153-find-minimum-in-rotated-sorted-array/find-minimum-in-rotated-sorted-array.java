class Solution {
    public int findMin(int[] nums) {
        boolean leftSorted=false;
        boolean rightSorted=false;

        int left=0;
        int right=nums.length-1;
        int res=Integer.MAX_VALUE;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[left]<=nums[mid]) leftSorted=true;
            else leftSorted=false;
            if(nums[mid]<=nums[right]) rightSorted=true;
            else rightSorted=false;

            if(leftSorted && rightSorted){
                res=Math.min(res, nums[left]);
                return res;
            } else if(leftSorted){
                res=Math.min(res, nums[left]);
                left=mid+1;
            } else{
                res=Math.min(res, nums[mid]);
                right=mid-1;
            }

            System.out.print("res: "+res+"\n");
        }

        return res;
    }
}