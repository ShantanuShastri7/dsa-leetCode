class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();

        for(int i : nums){
            s.add(i);
        }

        for(int i=1; i<Integer.MAX_VALUE; i++){
            int num = k*i;
            if(!s.contains(num)) return num;
        }
        return 0;
    }
}