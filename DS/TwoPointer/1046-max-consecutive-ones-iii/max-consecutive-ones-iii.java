class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int left = 0;
        int right = 0;
        int skips=0;
        int zeros=0;

        while(left<nums.length && right<nums.length){
            if(nums[right]==1){
                right++;
            } else if(nums[right]==0 && skips<k){
                skips++;
                right++;
            } else {
                if(nums[left]==0){
                    skips--;
                    left++;
                } else{
                    left++;
                }
            }

            max = Math.max(max, right-left);
        }

        return max;
    }
}