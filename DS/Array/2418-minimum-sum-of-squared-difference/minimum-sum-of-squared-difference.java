class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        
        // 1. Find the maximum difference to size our bucket array appropriately
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff);
        }
        
        // If all differences are already 0, we can't improve it further
        if (maxDiff == 0) return 0;
        
        // 2. Build the buckets (frequency array)
        // bucket[i] stores how many pairs have an absolute difference of exactly 'i'
        int[] buckets = new int[maxDiff + 1];
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            buckets[diff]++;
        }
        
        // 3. Combine k1 and k2 into one big pool of operations
        // Use 'long' because 10^9 + 10^9 = 2 * 10^9 (close to integer limit)
        long k = (long) k1 + k2;
        
        // 4. Push differences down in bulk, starting from the largest difference
        for (int i = maxDiff; i > 0; i--) {
            if (buckets[i] > 0) {
                // How many elements can we afford to push down?
                // Either all of them (buckets[i]), or whatever 'k' we have left.
                long shift = Math.min((long) buckets[i], k);
                
                // Move them down to the next bucket
                buckets[i] -= shift;
                buckets[i - 1] += shift;
                
                // Pay the cost
                k -= shift;
                
                // If we run out of operations, stop completely
                if (k == 0) {
                    break;
                }
            }
        }
        
        // 5. Calculate the final sum of squared differences
        long res = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (buckets[i] > 0) {
                // Must cast to long BEFORE multiplying to prevent integer overflow
                res += (long) buckets[i] * (long) i * (long) i;
            }
        }
        
        return res;
    }
}