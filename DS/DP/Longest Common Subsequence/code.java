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
