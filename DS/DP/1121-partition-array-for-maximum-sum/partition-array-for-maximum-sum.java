class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length+1];
        for(int i=0; i<=arr.length; i++){
            dp[i]=-1;
        }
        return helper(arr, k, 0, dp);
    }

    private int helper(int[] arr, int k, int start, int dp[]){
        if(start==arr.length) return 0;
        int maxCost = Integer.MIN_VALUE;
        int maxElem = 0;

        if(dp[start]!=-1) return dp[start];

        for(int i=0; i<k; i++){
            if(start+i==arr.length) break;
            maxElem=Math.max(maxElem, arr[start+i]);
            int cost = maxElem*(i+1)+helper(arr, k, start+i+1, dp);
            maxCost=Math.max(maxCost, cost);
        }

        return dp[start]=maxCost;
    }
}