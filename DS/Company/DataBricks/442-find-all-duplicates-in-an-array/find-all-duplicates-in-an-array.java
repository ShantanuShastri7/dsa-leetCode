class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        boolean[] order = new boolean[n+1];

        ArrayList<Integer> result = new ArrayList<>();

        for(int i : nums){
            if(order[i]==true) result.add(i);
            else order[i]=true;
        }

        return result;
    }
}