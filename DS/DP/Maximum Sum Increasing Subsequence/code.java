class Solution {
    public int maxSumIS(int arr[]) {
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int i=0; i<arr.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(arr, 0, -1, dp);
    }
    
    private int helper(int[] arr, int index, int previousIndex, int[][] dp){
        if(index>=arr.length) return 0;
        
        if(dp[index][previousIndex+1]!=-1) return dp[index][previousIndex+1];
        
        int notPick = helper(arr, index+1, previousIndex, dp);
        
        int pick = 0;
        if(previousIndex==-1 || arr[index]>arr[previousIndex]){
            pick = arr[index] + helper(arr, index+1, index, dp);
        }
        
        return dp[index][previousIndex+1] = Math.max(notPick, pick);
    }
}
