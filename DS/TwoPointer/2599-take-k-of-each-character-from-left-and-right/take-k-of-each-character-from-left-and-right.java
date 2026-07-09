class Solution {
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        // 1. Your exact initial check!
        for (int i = 0; i < 3; i++) {
            if (count[i] - k < 0) return -1;
        }
        
        int maxWindow = 0;
        int left = 0;
        
        // 2. 'right' pointer expands the middle window (just like index+1 in recursion)
        for (int right = 0; right < s.length(); right++) {
            // Absorb the character into our middle window by decrementing its allowance
            count[s.charAt(right) - 'a']--;
            
            // 3. Guardrail: If any count goes below k (meaning allowance < 0),
            // our window is too greedy! We shrink from the left until it's valid again.
            while (count[0] < k || count[1] < k || count[2] < k) {
                count[s.charAt(left) - 'a']++; // Put the character back!
                left++;                        // Shrink the window
            }
            
            // 4. Track the largest valid middle window we've found so far
            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        
        // The answer is the total length minus the largest untouched middle window!
        return s.length() - maxWindow;
    }
}


// class Solution {
//     public int takeCharacters(String s, int k) {
//         int[] count = new int[3];

//         for (int i = 0; i < s.length(); i++) {
//             count[s.charAt(i) - 'a']++;
//         }
//         for (int i = 0; i < 3; i++) {
//             if (count[i] - k < 0)
//                 return -1;
//         }
//         int result = Integer.MAX_VALUE;

//         for (int i = 0; i < s.length(); i++) {
//             int end = helper(s, count[0] - k, count[1] - k, count[2] - k, i);
//             if (end == -1)
//                 continue;
//             result = Math.min(result, s.length() - (end - i));
//         }

//         return result == Integer.MAX_VALUE ? -1 : result;
//     }

//     private int helper(String s, int aCount, int bCount, int cCount, int index) {
//         if (aCount < 0 || bCount < 0 || cCount < 0) {
//             return index - 1;
//         }

//         if (index == s.length()) {
//             return index;
//         }

//         int currentIndex = s.charAt(index) - 'a';
//         if (currentIndex == 0)
//             aCount--;
//         else if (currentIndex == 1)
//             bCount--;
//         else
//             cCount--;

//         return helper(s, aCount, bCount, cCount, index + 1);
//     }
// }