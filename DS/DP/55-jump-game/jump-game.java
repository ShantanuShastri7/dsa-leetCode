class Solution {
    public boolean canJump(int[] nums) {
        int[] mem = new int[nums.length];
        Arrays.fill(mem, -1);

        return helper(nums, 0, mem)==1?true:false;
    }

    private int helper(int[] nums, int index, int[] mem){
        if(index==nums.length-1) return 1;
        else if(index>=nums.length) return 0;

        if(mem[index]!=-1) return mem[index];

        int jumps = nums[index];
        int canDo =0;

        for(int i=1; i<=jumps; i++){
            canDo = helper(nums, index+i, mem);
            if(canDo==1) return mem[index] = canDo;
        }

        return mem[index] = 0;
    }
}