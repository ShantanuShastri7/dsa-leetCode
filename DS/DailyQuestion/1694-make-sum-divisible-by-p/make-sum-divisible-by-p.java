class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total += x;
        int k = (int)(total % p);
        if (k == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long prefix = 0L;
        int minLen = nums.length; 

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;       
            int rem = (int) prefix;               
            int needed = (rem - k + p) % p;

            if (map.containsKey(needed)) {
                minLen = Math.min(minLen, i - map.get(needed));
            }
            map.put(rem, i);
        }

        return minLen == nums.length ? -1 : minLen;
    }
}
