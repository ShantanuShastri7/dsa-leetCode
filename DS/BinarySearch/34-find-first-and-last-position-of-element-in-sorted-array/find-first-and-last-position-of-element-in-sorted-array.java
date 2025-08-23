class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1, -1};

        int i=0; 
        int j=nums.length-1;
        int lowerBound = 0;

        while(i<=j){
            int num = (i+j)/2;

            if(nums[num]>=target){
                lowerBound=num;
                j=num-1;
            } else{
                i=num+1;
            }
        }

        i=lowerBound; 
        j=nums.length-1;
        int upperBound=0;

        while(i<=j){
            int num = (i+j)/2;

            if(nums[num]<=target){
                upperBound=num;
                i=num+1;
            } else{
                j=num-1;
            }
        }

        if(nums[upperBound]!=target) return new int[]{-1,-1};
        return new int[]{lowerBound, upperBound};
    }
}