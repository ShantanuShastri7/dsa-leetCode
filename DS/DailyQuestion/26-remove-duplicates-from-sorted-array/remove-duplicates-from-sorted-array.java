class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==1) return 1;
        int unique=1; 
        int searcher=1;
        int uniqueCount=1;
        int anchor=0;

        while(searcher<nums.length){
            if(nums[anchor]==nums[searcher]) searcher++;
            else {
                nums[unique++]=nums[searcher];
                anchor=searcher;
                searcher++;
                uniqueCount++;
            }
        }
        return uniqueCount;
    }
}