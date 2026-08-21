class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int m = station.length();
        
        // Base case 
        if (n <= 1) return 0;
        
        int[][] skilMinMax = new int[n][2];

        // 1. One continuous pass for the Left (Min) positions
        int lst = 0;
        for (int lsk = 0; lsk < n; lsk++) {
            // Fast-forward station pointer until it matches
            while (skill.charAt(lsk) != station.charAt(lst)) {
                lst++;
            }
            skilMinMax[lsk][0] = lst;
            lst++; // Move past the assigned station for the next worker
        }

        // 2. One continuous pass for the Right (Max) positions
        int rst = m - 1;
        for (int rsk = n - 1; rsk >= 0; rsk--) {
            // Rewind station pointer until it matches
            while (skill.charAt(rsk) != station.charAt(rst)) {
                rst--;
            }
            skilMinMax[rsk][1] = rst;
            rst--; // Move past the assigned station for the next worker
        }

        // 3. Find the maximum gap
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            res = Math.max(res, skilMinMax[i + 1][1] - skilMinMax[i][0]);
        }

        return res;
    }
}