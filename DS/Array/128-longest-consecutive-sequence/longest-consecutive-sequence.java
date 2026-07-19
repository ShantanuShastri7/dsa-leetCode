class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res=0;

        for(int nu : nums){
            set.add(nu);
        }

        for (int num : set) {

            if (set.contains(num - 1))
                continue;

            int c=0;
            while (set.contains(num)) {
                c++;
                num++;
            }
            res=Math.max(res,c);
        }

        return res;
    }
}