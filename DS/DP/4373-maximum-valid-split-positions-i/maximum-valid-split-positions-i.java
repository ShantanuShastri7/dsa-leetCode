class Solution {
    public int maxValidSplits(int[] nums) {
        int maxScore = countValidSplits(nums, -1);
        
        for (int i = 0; i < nums.length; i++) {
            maxScore = Math.max(maxScore, countValidSplits(nums, i));
        }
        
        return maxScore;
    }

    private int countValidSplits(int[] nums, int skipIndex) {
        int m = (skipIndex == -1) ? nums.length : nums.length - 1;
        
        // The problem states an array of length 1 has no valid splits
        if (m <= 1) return 0; 
        
        // Build the new array to make our prefix/suffix logic effortless
        int[] arr = new int[m];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == skipIndex) continue;
            arr[idx++] = nums[i];
        }
        
        // From here down, this is exactly the logic you wrote!
        int[] prefix = new int[m];
        int[] suffix = new int[m];
        
        prefix[0] = arr[0];
        for (int i = 1; i < m; i++) {
            prefix[i] = gcd(arr[i], prefix[i - 1]);
        }
        
        suffix[m - 1] = arr[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            suffix[i] = gcd(arr[i], suffix[i + 1]);
        }
        
        // Check for valid splits
        int score = 0;
        for (int i = 0; i < m - 1; i++) {
            if (prefix[i] == suffix[i + 1]) {
                score++;
            }
        }
        
        return score;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}