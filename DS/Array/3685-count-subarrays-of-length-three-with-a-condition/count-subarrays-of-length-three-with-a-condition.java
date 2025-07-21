class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;

        for(int i = 0; i < nums.length-2; i++) {
            int left = nums[i];
            int mid = nums[i+1];
            int right = nums[i+2];
            if(((left+right)==(mid/2)) && (mid%2==0)) {
                count++;
            }
        }
        return count;
    }
}