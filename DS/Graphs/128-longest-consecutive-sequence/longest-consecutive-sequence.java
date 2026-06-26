class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        
        Set<Integer> set = new HashSet<>();

        for(int i : nums){
            set.add(i);
        }

        int result=1;

        for(Integer num : set){
            if(set.contains(num-1)){
                continue;
            } else {
                int mover = num;
                int count=1;
                while(set.contains(mover+1)){
                    count++;
                    mover++;
                }
                result=Math.max(result, count);
            }
        }

        return result;
    }
}