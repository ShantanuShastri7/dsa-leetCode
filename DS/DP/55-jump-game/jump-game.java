class Solution {
    public boolean canJump(int[] nums) {
        int[] mem = new int[nums.length];

        mem[nums.length-1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            int jumps = nums[i];
            int canDo = 0;

            for (int j = 1; j <= jumps; j++) {
                if(i+j<=nums.length){
                    canDo = mem[i+j];
                }
                if (canDo == 1){
                    mem[i] = canDo;
                    break;
                }
            }
        }

        return mem[0] == 1 ? true : false;
    }

    // public boolean canJump(int[] nums) {
    //     int[] mem = new int[nums.length];
    //     Arrays.fill(mem, -1);

    //     return helper(nums, 0, mem)==1?true:false;
    // }

    private int helper(int[] nums, int index, int[] mem) {
        if (index == nums.length - 1)
            return 1;
        else if (index >= nums.length)
            return 0;

        if (mem[index] != -1)
            return mem[index];

        int jumps = nums[index];
        int canDo = 0;

        for (int i = 1; i <= jumps; i++) {
            canDo = helper(nums, index + i, mem);
            if (canDo == 1)
                return mem[index] = canDo;
        }

        return mem[index] = 0;
    }
}