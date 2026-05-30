class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int firstPivot = nums[i];
            int remainingSum = 0 - firstPivot;
            int j = i+1;
            int k = nums.length-1;

            while(j<k){
                int sum = nums[j]+nums[k];

                if(sum<remainingSum) {
                    j++;
                }else if(sum>remainingSum) {
                    k--;
                }else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while(j<k && nums[j]==nums[j-1]) j++;
                }
            }

            while(i<nums.length-2 && nums[i]==nums[i+1]) i++;
        }
        
        return result;
    }
}