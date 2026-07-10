class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int result = Integer.MIN_VALUE;
        int x = nums.length-k;
        int[] lastMax = new int[x];
        x--;
        lastMax[x]=nums[nums.length-1];
        x--;

        for(int i=nums.length-2; i>=k; i--){
            lastMax[x]=Math.max(lastMax[x+1], nums[i]);
            x--;
        }

        for(int i=0; i<nums.length-k; i++){
            result=Math.max(result, nums[i]+lastMax[i]);
        }

        return result;
    }
}