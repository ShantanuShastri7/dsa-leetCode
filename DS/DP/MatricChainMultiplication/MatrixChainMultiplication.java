class Solution {
    public int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(arr, 1, arr.length-1, dp);
    }
    
    private int helper(int arr[], int start, int end, int dp[][]){
        if(start==end) return 0;
        
        if(dp[start][end]!=-1) return dp[start][end];
        
        int min=Integer.MAX_VALUE;
        for(int i=start; i<end; i++){
            int cost = arr[start-1]*arr[i]*arr[end]
                        + helper(arr, start, i, dp)
                        + helper(arr, i+1, end, dp);
            
            min = Math.min(min, cost);
        }
        
        return dp[start][end]=min;
    }
}
