class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Find intersection point
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entrance to cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


    //Brute force
    // public int findDuplicate(int[] nums) {
    //    boolean[] isPresent = new boolean[nums.length];

    //    for(int i : nums){
    //     if(isPresent[i]) return i;
    //     isPresent[i]=true;
    //    }

    //    return -1;
    // }
}