class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] minAhead = new int[nums.length];
        minAhead[nums.length-1] = nums[nums.length-1];

        for(int i=nums.length-2; i>=0; i--){
            minAhead[i] = Math.min(minAhead[i+1], nums[i]);
        }

        int maxSoFar = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            maxSoFar = Math.max(maxSoFar, nums[i]);

            if((maxSoFar - minAhead[i])<=k) return i;
        }

        return -1;
    }
}