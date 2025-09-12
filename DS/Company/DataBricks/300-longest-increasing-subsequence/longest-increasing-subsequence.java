class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];

        for(int i=0; i< nums.length; i++) Arrays.fill(memo[i], -1);

        if(nums.length<=1) return nums.length;

        int result = getLongest(nums, 0, -1, memo);

        return result;
    }

    private int getLongest(int[] nums, int index, int prev, int[][] memo){
        if(index==nums.length) return 0;

        if(prev!=-1 && memo[index][prev+1]!=-1) return memo[index][prev+1];

        int pick=0;
        int notPick=0;

        notPick = getLongest(nums, index+1, prev, memo);

        if(prev==-1 || nums[prev]<nums[index]){
            pick = 1 + getLongest(nums, index+1, index, memo);
        } 

        return memo[index][prev+1] = Math.max(pick, notPick);
    }
}