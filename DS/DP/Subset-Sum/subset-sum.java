
//memoization
class Solution {

    public Boolean isSubsetSum(int arr[], int sum) {
        int dp[][] = new int[arr.length][sum+1];
        for(int i=0; i<arr.length; i++){
            Arrays.fill(dp[i], -1);
        }
        helper(arr, sum, arr.length-1, dp);
        
        return dp[arr.length-1][sum]==1;
    }
    
    private int helper(int arr[], int target, int index, int dp[][]){
        if(target==0) return 1;
        
        if(index==0) {
            return target==arr[index]?1:0;
        }
        
        if(dp[index][target]!=-1) return dp[index][target];
        
        int notPick = helper(arr, target, index-1, dp);
        int pick = 0;
        if(target>=arr[index]){
            pick = helper(arr, target-arr[index], index-1, dp);
        }
        
        return dp[index][target] = (pick==1 || notPick==1)?1:0;
    }
}

//recursive dp -> TLE
class Solution {

    public Boolean isSubsetSum(int arr[], int sum) {
        return helper(arr, sum, arr.length-1);
    }
    
    private boolean helper(int arr[], int target, int index){
        if(index==0 && target!=0) return false;
        if(target==0) return true;
        
        boolean notPick = helper(arr, target, index-1);
        boolean pick = false;
        if(target>=arr[index]){
            pick = helper(arr, target-arr[index], index-1);
        }
        
        return pick||notPick;
    }
}
