class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();

        for(int i=0; i<n; i++){
            int rem = -nums[i];
            Map<Integer, Integer> list = new HashMap<>();

            for(int j=i+1; j<n; j++){
                if(list.containsKey(rem-nums[j])){
                    list.put(nums[j], 0);
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], rem-nums[j])));
                }
                list.put(nums[j], 0);
            }
        }

        return new ArrayList<>(result);
    }
}