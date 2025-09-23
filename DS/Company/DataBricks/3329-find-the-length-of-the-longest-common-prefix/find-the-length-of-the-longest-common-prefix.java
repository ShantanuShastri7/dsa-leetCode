import java.util.*;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> prefixSet = new HashSet<>();

        // Step 1: Add all prefixes of arr1 numbers to HashSet
        for (int num : arr1) {
            String str = String.valueOf(num);
            StringBuilder prefix = new StringBuilder();
            for (char c : str.toCharArray()) {
                prefix.append(c);
                prefixSet.add(prefix.toString());
            }
        }

        // Step 2: For each number in arr2, check its prefixes
        int maxLen = 0;
        for (int num : arr2) {
            String str = String.valueOf(num);
            StringBuilder prefix = new StringBuilder();
            for (char c : str.toCharArray()) {
                prefix.append(c);
                if (prefixSet.contains(prefix.toString())) {
                    maxLen = Math.max(maxLen, prefix.length());
                }
            }
        }

        return maxLen;
    }
}