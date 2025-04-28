class Solution {
    public long countSubarrays(int[] nums, long k) {
        long result = 0;
        long sum = 0;
        for(int l=0, r=0; r<nums.length; r++){
            sum+=nums[r];
            while(l<=r && (sum*(r-l+1)>=k)){
                sum-=nums[l];
                l++;
            }
            result+=(r-l+1);
        }
        return result;
    }
}