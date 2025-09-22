import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Build frequency for p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int windowSize = p.length();

        // Sliding window
        for (int i = 0; i < s.length(); i++) {
            // Add current char to window
            sCount[s.charAt(i) - 'a']++;

            // Remove char left of the window
            if (i >= windowSize) {
                sCount[s.charAt(i - windowSize) - 'a']--;
            }

            // Compare frequency arrays
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }
}
