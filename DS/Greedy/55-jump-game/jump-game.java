class Solution {
    public boolean canJump(int[] nums) {
        int[] canArrive = new int[nums.length];
        canArrive[0]=1;
        helper(nums, 1, canArrive);
        return canArrive[nums.length-1]==1;
    }
    private void helper(int[] nums, int index, int[] canArrive){
        if(index==nums.length) return;
        for(int i=index-1; i>=0; i--){
            if(canArrive[i]==1 && nums[i]>=index-i){
                canArrive[index]=1;
                break;
            }
        }

        helper(nums, index+1, canArrive);
    }
}