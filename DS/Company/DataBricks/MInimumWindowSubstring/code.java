import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        // Step 1: Count characters in t
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // Two pointers
        int left = 0, right = 0;
        int required = need.size(); // total unique characters in t
        int formed = 0; // how many unique chars currently satisfied

        Map<Character, Integer> window = new HashMap<>();

        // Result: length, left, right
        int minLen = Integer.MAX_VALUE;
        int ansLeft = 0, ansRight = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // If char count matches in window and need, increase formed
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // Contract from the left as long as window is valid
            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    ansLeft = left;
                    ansRight = right;
                }

                // Shrink window
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) && window.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }

            // Expand window
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(ansLeft, ansRight + 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(sol.minWindow(s, t)); // Output: "BANC"
    }
}
