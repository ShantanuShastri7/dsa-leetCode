class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int res = 0;
        int n = img1.length;
        
        // Extract all '1's so we don't waste time looping over '0's
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) ones1.add(new int[]{i, j});
                if (img2[i][j] == 1) ones2.add(new int[]{i, j});
            }
        }

        // Optimization: Keep track of translations we've already checked 
        // so we don't recalculate the exact same overlap twice
        Set<String> checkedShifts = new HashSet<>();
        
        // 1. Try EVERY '1' in img2 as an anchor
        for (int[] anchor2 : ones2) {
            
            // Build the 'toBe' pattern relative to this specific anchor
            List<int[]> toBe = new ArrayList<>();
            for (int[] cell : ones2) {
                toBe.add(new int[]{cell[0] - anchor2[0], cell[1] - anchor2[1]});
            }
            
            // 2. Try placing this pattern's anchor on EVERY '1' in img1
            for (int[] anchor1 : ones1) {
                
                int dx = anchor1[0] - anchor2[0];
                int dy = anchor1[1] - anchor2[1];
                String shift = dx + "," + dy;
                
                // If we haven't evaluated this exact alignment yet, check the pattern
                if (checkedShifts.add(shift)) {
                    res = Math.max(res, checkPattern(img1, anchor1[0], anchor1[1], toBe));
                }
            }
        }
        
        return res;
    }

    // Your checkPattern fixed: No need to loop over the whole matrix again!
    // Just apply the 'toBe' offsets to our anchor in img1 and count the matches.
    private int checkPattern(int[][] img1, int anchorI, int anchorJ, List<int[]> toBe) {
        int count = 0;
        int n = img1.length;
        
        for (int[] diff : toBe) {
            int targetI = anchorI + diff[0];
            int targetJ = anchorJ + diff[1];
            
            // If the target coordinate is within the matrix bounds and is a '1'
            if (targetI >= 0 && targetI < n && targetJ >= 0 && targetJ < n) {
                if (img1[targetI][targetJ] == 1) {
                    count++;
                }
            }
        }
        
        return count;
    }
}