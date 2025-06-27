class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        int result = helper(n,memo);

        return result;
    }

    private int helper(int n, int[] memo){
        if(n<=1) return 1;

        if(memo[n]!=-1) return memo[n];

        memo[n] = helper(n-1, memo) + helper(n-2, memo);

        return memo[n];
    }
}