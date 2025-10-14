class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int[] dp = new int[energy.length];
        Arrays.fill(dp, -1);
        int max = Integer.MIN_VALUE;

        for(int i=0; i<energy.length; i++){
            max = Math.max(max, dp(energy, dp, i, k));
        }

        return max;
    }

    private int dp(int[] energy, int[] dp, int index, int k){
        if(index>=energy.length) return 0;

        if(dp[index]!=-1) return dp[index];

        int pick = energy[index] + dp(energy, dp, index+k, k);

        return dp[index]=pick;
    }
}