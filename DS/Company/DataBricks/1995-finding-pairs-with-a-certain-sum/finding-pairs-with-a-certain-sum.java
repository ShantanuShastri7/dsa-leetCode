import java.util.*;

class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> freqMap; // frequency of elements in nums2

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        freqMap = new HashMap<>();

        // Build frequency map for nums2
        for (int num : nums2) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        // Reduce frequency of old value
        int oldVal = nums2[index];
        freqMap.put(oldVal, freqMap.get(oldVal) - 1);
        if (freqMap.get(oldVal) == 0) {
            freqMap.remove(oldVal);
        }

        // Update nums2[index]
        nums2[index] += val;

        // Increase frequency of new value
        freqMap.put(nums2[index], freqMap.getOrDefault(nums2[index], 0) + 1);
    }
    
    public int count(int tot) {
        int count = 0;

        // For each number in nums1, find complement in nums2
        for (int num : nums1) {
            int complement = tot - num;
            count += freqMap.getOrDefault(complement, 0);
        }

        return count;
    }
}