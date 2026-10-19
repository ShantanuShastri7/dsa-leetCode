class Solution {
    public int sumCounts(List<Integer> nums) {
        int res=0;

        for(int i=0; i<nums.size(); i++){
            Set<Integer> se = new HashSet<>();
            for(int j=i; j<nums.size(); j++){
                se.add(nums.get(j));
                res+=(int) Math.pow(se.size(), 2);
            }
        }

        return res;
    }
}