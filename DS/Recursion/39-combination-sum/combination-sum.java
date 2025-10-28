class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Integer[] arr = Arrays.stream(candidates).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        Set<ArrayList<Integer>> res = new HashSet<>();
        ArrayList<Integer> cur = new ArrayList<>();
        helper(arr, target, 0, 0, res, cur);

        List<List<Integer>> finalRes = new ArrayList<>();
        Iterator<ArrayList<Integer>> it = res.iterator();
        while (it.hasNext()) {
            finalRes.add(it.next());
        }
        return finalRes;
    }

    private void helper(Integer[] candidates, int target, int index, int sum, Set<ArrayList<Integer>> result, ArrayList<Integer> curr){
        if(index>=candidates.length){
            if(sum==target){
                result.add(new ArrayList<>(curr));
                return;
            } else  return;
        }

        if(target-sum>=candidates[index]){
            helper(candidates, target, index+1, sum, result, curr);
            curr.add(candidates[index]);
            sum+=candidates[index];
            helper(candidates, target, index, sum, result, curr);
            sum-=candidates[index];
            curr.remove(curr.size()-1);
        } else {
            helper(candidates, target, index+1, sum, result, curr);
        }
    }
}