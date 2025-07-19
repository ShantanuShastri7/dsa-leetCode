class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int maxi=1;

        for(int i=0; i<n; i++){
            int prev = nums[i];
            int count=1;
            for(int j=i+1; j<n; j++){
                if(nums[j]>prev){
                    count+=1;
                    prev=nums[j];
                    maxi=Math.max(count, maxi);
                } else break;
            }
        }

        return maxi;
    }
}