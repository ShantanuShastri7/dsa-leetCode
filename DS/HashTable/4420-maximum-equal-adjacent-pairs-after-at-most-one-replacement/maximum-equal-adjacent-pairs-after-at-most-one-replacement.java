class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            StringBuilder str1 = new StringBuilder();
            int small = Math.min(nums[i], nums[i + 1]);
            int large = Math.max(nums[i], nums[i + 1]);

            str1.append(small);
            str1.append(",");
            str1.append(large);

            String str = str1.toString();

            if (small == large)
                res++;
            else {
                if (!map.containsKey(str)) {
                    map.put(str, 1);
                } else {
                    map.put(str, map.get(str) + 1);
                }
            }
        }

        int largest = 0;

        // Iterate through the map entries easily
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            largest = Math.max(largest, entry.getValue());
        }

        return res + largest;
    }
}