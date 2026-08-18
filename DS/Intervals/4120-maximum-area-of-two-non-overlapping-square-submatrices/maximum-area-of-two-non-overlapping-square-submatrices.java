class Solution {
    public int maxArea(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                // If the cell is 0, it can't form a square. Leave it as 0.
                if (mat[r][c] == 1) {
                    // Base case: Top edge or Left edge can only ever form a square of size 1
                    if (r == 0 || c == 0) {
                        dp[r][c] = 1;
                    } else {
                        // The magic formula: 1 + minimum of the 3 neighbors
                        int top = dp[r - 1][c];
                        int left = dp[r][c - 1];
                        int topLeft = dp[r - 1][c - 1];

                        dp[r][c] = 1 + Math.min(topLeft, Math.min(top, left));
                    }
                }
            }
        }

        int min=1;
        int max=Math.min(mat.length, mat[0].length);
        int res=0;

        while(min<=max){
            int mid = min + (max-min)/2;

            if(possible(dp, mid)){
                res=mid;
                min=mid+1;
            }else{
                max=mid-1;
            }
        }
        return res*res;
    }

    private boolean possible(int[][] dp, int sqSize){
        // FIX 1: Initialize mins to MAX_VALUE and maxes to -1
        int rMax = -1;
        int rMin = Integer.MAX_VALUE;
        int cMax = -1;
        int cMin = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] >= sqSize) {
                    rMax = Math.max(rMax, i);
                    rMin = Math.min(rMin, i);
                    cMax = Math.max(cMax, j);
                    cMin = Math.min(cMin, j);
                    found = true;
                }
            }
        }

        // If we didn't even find one square of this size, it's impossible
        if (!found) return false;

        return (rMax - rMin >= sqSize) || (cMax - cMin >= sqSize);
    }
}