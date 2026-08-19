class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int res = Integer.MAX_VALUE;

        // 'k' represents the number of Left Rotations we perform
        for (int k = 0; k < n; k++) {
            
            // Base cost: We performed 'k' left rotations
            int cost = k; 
            
            // Pointers start at the "ends" of the newly rotated string
            int l = k;
            int r = (k + n - 1) % n;
            
            // Walk inward, only needing to check half the string length
            for (int travel = 0; travel < n / 2; travel++) {
                char c1 = s.charAt(l);
                char c2 = s.charAt(r);
                
                if (c1 != c2) {
                    // Find the absolute difference between the characters
                    int diff = Math.abs(c1 - c2);
                    // The cost is the shortest path on a 26-letter circle
                    cost += Math.min(diff, 26 - diff);
                }
                
                // Move pointers inward toward the center
                l = (l + 1) % n;
                r = (r - 1 + n) % n;
            }
            
            res = Math.min(res, cost);
        }

        return res;
    }
}