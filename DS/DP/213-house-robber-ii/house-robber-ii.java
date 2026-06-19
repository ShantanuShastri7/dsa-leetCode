class Solution {
    public int rob(int[] nums) {
        int[] mem = new int[nums.length];
        int[] mem1 = new int[nums.length];
        Arrays.fill(mem, -1);
        Arrays.fill(mem1, -1);

        int answer = Math.max(nums[0]+helper(nums, 2, mem, nums.length-1), helper(nums, 1, mem1, nums.length));

        return answer;
    }

    private int helper(int[] nums, int index, int[] mem, int endIndex){
        if(index>=endIndex) return 0;

        if(mem[index]!=-1) return mem[index];

        int pick = nums[index] + helper(nums, index+2, mem, endIndex);

        int notPick = helper(nums, index+1, mem, endIndex);

        return  mem[index] = Math.max(pick, notPick);
    }
}