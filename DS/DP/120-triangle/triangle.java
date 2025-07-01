class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int val = triangle.get(i).get(j);
                if (j == 0) {
                    temp[j] = dp[j] + val;
                } else if (j == triangle.get(i).size() - 1) {
                    temp[j] = dp[j - 1] + val;
                } else {
                    temp[j] = Math.min(dp[j - 1], dp[j]) + val;
                }
            }
            dp = temp;
        }

        return Arrays.stream(dp).min().getAsInt();
    }

    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int[][] memo = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
    //     for(int i=0; i<memo[0].length; i++){
    //         Arrays.fill(memo[i], 10000000);
    //     }
    //     return helper(triangle, 0, 0, memo);
    // }

    private int helper(List<List<Integer>> triangle, int level, int index, int[][] memo) {
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(index);
        }
        if (level > triangle.size() - 1 || index > triangle.get(level).size() - 1)
            return 1000000;
        if (memo[level][index] != 10000000)
            return memo[level][index];

        int minSum = 0;
        int below = triangle.get(level).get(index) + helper(triangle, level + 1, index, memo);
        int belowAhead = triangle.get(level).get(index) + helper(triangle, level + 1, index + 1, memo);

        return memo[level][index] = Math.min(below, belowAhead);
    }
}