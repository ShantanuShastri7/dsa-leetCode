class Solution {
    public String minWindow(String s, String t) {
        // Edge cases
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] counts = new int[128];
        for (char c : t.toCharArray()) {
            counts[c]++;
        }
        
        int debt = t.length();
        int l = 0;
        int r = 0;
        
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        // 2. Expand the window with the right pointer
        while (r < s.length()) {
            char rightChar = s.charAt(r);
            
            // If the character is useful, reduce our debt
            if (counts[rightChar] > 0) {
                debt--;
            }
            // Always reduce the count (surplus characters go negative)
            counts[rightChar]--;
            r++; // Move right pointer forward to expand

            // 3. Shrink the window with the left pointer while valid
            while (debt == 0) {
                // Record the current window if it's the smallest so far
                // Note: Current length is (r - l) because r was already incremented
                if (r - l < minLen) {
                    minLen = r - l;
                    minStart = l;
                }
                
                char leftChar = s.charAt(l);
                
                // Put the character back into our count requirement
                counts[leftChar]++;
                
                // If the count becomes > 0, we just lost a required character
                if (counts[leftChar] > 0) {
                    debt++;
                }
                
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}