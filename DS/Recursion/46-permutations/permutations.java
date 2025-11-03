class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        helper(nums, result, curr);

        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, ArrayList<Integer> current){
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i : nums){
            if(current.contains(i)){
                continue;
            } else{
                current.add(i);
                helper(nums, result, current);
                current.remove((Integer) i);
            }
        }

        return;
    }
}