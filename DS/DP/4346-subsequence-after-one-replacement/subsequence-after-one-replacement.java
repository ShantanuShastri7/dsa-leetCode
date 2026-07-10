class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        // If s is longer than t by more than 1 character, 
        // it's impossible to make it a subsequence even with 1 replacement.
        if (n > m + 1) return false;

        // pref[i] stores the earliest index in t that can match s[0...i]
        int[] pref = new int[n];
        // suff[i] stores the latest index in t that can match s[i...n-1]
        int[] suff = new int[n];

        // 1. Build the prefix array (Left-to-Right Greedy Match)
        int tIdx = 0;
        for (int i = 0; i < n; i++) {
            while (tIdx < m && t.charAt(tIdx) != s.charAt(i)) {
                tIdx++;
            }
            if (tIdx < m) {
                pref[i] = tIdx;
                tIdx++; // Move to next character in t for the next iteration
            } else {
                pref[i] = m; // Sentinel value meaning out of bounds / unmatched
            }
        }

        // 2. Build the suffix array (Right-to-Left Greedy Match)
        tIdx = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (tIdx >= 0 && t.charAt(tIdx) != s.charAt(i)) {
                tIdx--;
            }
            if (tIdx >= 0) {
                suff[i] = tIdx;
                tIdx--; // Move left in t for the next iteration
            } else {
                suff[i] = -1; // Sentinel value meaning out of bounds / unmatched
            }
        }

        // 3. Check every single index as a candidate for replacement
        for (int i = 0; i < n; i++) {
            // Find where the valid prefix ends (before index i)
            int leftBoundary = (i == 0) ? -1 : pref[i - 1];
            
            // Find where the valid suffix begins (after index i)
            int rightBoundary = (i == n - 1) ? m : suff[i + 1];

            // If the prefix before 'i' and suffix after 'i' are both valid,
            // check if there is at least ONE unused character in t between them.
            if (leftBoundary < m && rightBoundary > -1 && rightBoundary - leftBoundary >= 2) {
                return true;
            }
        }

        return false;
    }
}