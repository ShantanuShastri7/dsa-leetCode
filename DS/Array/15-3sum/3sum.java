class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}






// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);
//         int n = nums.length;
//         Set<List<Integer>> result = new HashSet<>();

//         for(int i=0; i<n; i++){
//             int rem = -nums[i];
//             Map<Integer, Integer> list = new HashMap<>();

//             for(int j=i+1; j<n; j++){
//                 if(list.containsKey(rem-nums[j])){
//                     list.put(nums[j], 0);
//                     result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], rem-nums[j])));
//                 }
//                 list.put(nums[j], 0);
//             }
//         }

//         return new ArrayList<>(result);
//     }
// }