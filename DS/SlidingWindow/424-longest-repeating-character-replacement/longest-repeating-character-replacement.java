class Solution {
    public int characterReplacement(String s, int k) {
        int maxF = 0;
        int[] charCount = new int[26];

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            charCount[c - 'A']++;
            
            maxF = Math.max(maxF, charCount[c - 'A']);

            while ((right - left + 1) - maxF > k) {
                //No need to keep track of maxF while reducing, any new window that has to break the largest window size so far would have to break the maxF size as well.
                char b = s.charAt(left);
                charCount[b - 'A']--;
                left++; 
            }
            
        
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}