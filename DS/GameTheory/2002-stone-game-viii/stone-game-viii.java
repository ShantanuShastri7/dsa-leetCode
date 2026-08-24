class Solution {
    public int stoneGameVIII(int[] stones) {

        int[] prefixSumStones = new int[stones.length-1];

        prefixSumStones[0] = stones[0]+stones[1];

        for(int i=1; i<stones.length-1; i++){
            prefixSumStones[i]=prefixSumStones[i-1]+stones[i+1];
        }

        int[] dp = new int[stones.length-1];

        for(int i=stones.length-2; i>=0; i--){
            if(i==stones.length-2){
                dp[i]=prefixSumStones[i];
            } else{
                int opponentNextBest = dp[i+1];
                dp[i]=Math.max(prefixSumStones[i] - dp[i + 1], dp[i + 1]);
            }
        }

        return dp[0];
    }
}