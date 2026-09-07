class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        
        // This tracks the number of sequences generated the *last time* we saw each letter
        int[] lastAdded = new int[26]; 
        
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            
            // Step 1: Calculate raw new sequences (Current Total + 1 for the letter itself)
            int rawNew = (total + 1) % MOD;
            
            // Step 2: Subtract duplicates (what we added the last time we saw this letter)
            // We add MOD before the modulo to prevent Java from returning a negative number!
            int netNew = (rawNew - lastAdded[charIndex] + MOD) % MOD;
            
            // Step 3: Record the raw amount we added for this specific letter
            lastAdded[charIndex] = rawNew;
            
            // Step 4: Update our running total with only the net new sequences
            total = (total + netNew) % MOD;
        }

        return total;
    }
}