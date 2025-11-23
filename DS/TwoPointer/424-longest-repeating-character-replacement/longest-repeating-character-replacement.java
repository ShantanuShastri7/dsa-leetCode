class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0; 
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq[c - 'A']++;

            maxFreq = Math.max(maxFreq, freq[c - 'A']);

            // If window is invalid: (#chars to replace > k)
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;  
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}