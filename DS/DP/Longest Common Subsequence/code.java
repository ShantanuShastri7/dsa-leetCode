class Solution {
    static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        // Notice the +1! This allows index 0 to represent an "empty string".
        int[][] mem = new int[m + 1][n + 1];
        
        // 1. INSERT BASE CASES
        // If string 2 is empty (length 0), the LCS is always 0.
        for (int i = 0; i <= m; i++) {
            mem[i][0] = 0;
        }
        // If string 1 is empty (length 0), the LCS is always 0.
        for (int j = 0; j <= n; j++) {
            mem[0][j] = 0;
        }
        // Note: Java automatically initializes int arrays to 0, so these loops 
        // are technically optional, but they perfectly demonstrate the bottom-up logic!

        // 2. BOTTOM-UP CALCULATION
        // We start loops at 1 because index 0 is our base case (empty string).
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                
                // Because our loop starts at 1, we must look at charAt(i-1) and charAt(j-1)
                // Scenario A: Characters Match
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // Look diagonally up-left (the answer before adding these matching chars)
                    mem[i][j] = 1 + mem[i - 1][j - 1];
                } 
                // Scenario B: Characters Mismatch
                else {
                    // Look directly above and directly to the left, take the max
                    mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
                }
            }
        }
        
        // The final answer always ends up in the absolute bottom-right cell
        return mem[m][n];
    }


class Solution {
    static int lcs(String s1, String s2) {
        int[][] mem = new int[s1.length()][s2.length()];
        
        for(int i = 0; i < s1.length(); i++){
            Arrays.fill(mem[i], -1);
        }
        
        return helper(s1, s2, s1.length() - 1, s2.length() - 1, mem);
    }
    
    private static int helper(String one, String two, int sOne, int sTwo, int[][] mem) {
        // Base Case
        if(sOne < 0 || sTwo < 0) {
            return 0;
        }
        
        // Memoization Check
        if(mem[sOne][sTwo] != -1) return mem[sOne][sTwo];
        
        // Scenario A: Characters Match (Take them and move both pointers)
        if(one.charAt(sOne) == two.charAt(sTwo)) {
            return mem[sOne][sTwo] = 1 + helper(one, two, sOne - 1, sTwo - 1, mem);
        } 
        // Scenario B: Characters Mismatch (Branch to find the best alternative)
        else {
            int moveOne = helper(one, two, sOne - 1, sTwo, mem);
            int moveTwo = helper(one, two, sOne, sTwo - 1, mem);
            return mem[sOne][sTwo] = Math.max(moveOne, moveTwo);
        }
    }
}
