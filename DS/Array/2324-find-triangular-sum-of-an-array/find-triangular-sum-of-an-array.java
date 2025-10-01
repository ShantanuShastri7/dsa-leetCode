class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length; 
        int repeat = n;
        
        while(repeat>0){
            for(int i=1; i<n; i++){
                int left = nums[i-1];
                int right = nums[i];

                nums[i-1]=(left+right)%10;
            }
            repeat--;
            n--;
        }

        return nums[0];
    }
}