class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case: prefix sum of 0 appears once

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            // If there exists a previous prefixSum such that 
            // currentSum - previousSum = k
            //To find sum of any sub array array[i,j] = prefixSum[j]-prefixSum[j-1]
            //Re arraginging k = prefixSum[j]-prefixSum[j-1]
            // prefixSum[j-1]= prefixSum[i] - k;
            //prefixSum[j-1] is basically any previous key in Map
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Store the current prefixSum count
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
