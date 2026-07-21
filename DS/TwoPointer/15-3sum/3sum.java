class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int i = 0;

        while (i < nums.length - 2) {
            int sum = -nums[i];
            int l = i + 1;
            int m = nums.length - 1;

            while (l < m) {
                if (nums[l] + nums[m] == sum) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[m])));
                    l++;
                    m--;
                    while(l<m && nums[l-1]==nums[l]){
                        l++;
                    }
                } else if (nums[l] + nums[m] > sum) {
                    m--;
                } else {
                    l++;
                }
            }
            i++;
            while (i < nums.length - 2 && nums[i - 1] == nums[i]) {
                i++;
            }
        }

        return res;
    }
}