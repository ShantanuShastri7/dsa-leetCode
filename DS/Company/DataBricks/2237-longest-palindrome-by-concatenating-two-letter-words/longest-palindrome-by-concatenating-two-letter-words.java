import java.util.*;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int length = 0;
        boolean hasCenter = false;

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : map.keySet()) {
            String reverse = new StringBuilder(word).reverse().toString();

            // Case 1: Word is self-mirrored, e.g., "aa"
            if (word.equals(reverse)) {
                int count = map.get(word);
                length += (count / 2) * 4; // Each pair contributes 4 characters
                if (count % 2 == 1) {
                    hasCenter = true; // Keep one unpaired for the center
                }
            }
            // Case 2: Pair "ab" with "ba"
            else if (map.containsKey(reverse)) {
                int pairs = Math.min(map.get(word), map.get(reverse));
                length += pairs * 4;
                map.put(word, 0); // Avoid double counting
                // map.put(reverse, 0);
            }
        }

        // Add 2 if there's a central self-mirrored word like "aa"
        if (hasCenter) {
            length += 2;
        }

        return length;
    }
}