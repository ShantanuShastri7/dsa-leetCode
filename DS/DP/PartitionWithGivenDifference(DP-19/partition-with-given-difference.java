// tabulation
class Solution {
    int countPartitions(int[] arr, int d) {
        int total = Arrays.stream(arr).sum();
        if (total < d || (total - d) % 2 != 0) return 0;

        int target = (total - d) / 2;
        int[][] dp = new int[arr.length][target + 1];

        if (arr[0] == 0) {
            dp[0][0] = 2;  
        } else {
            dp[0][0] = 1; 
        }

        if (arr[0] != 0 && arr[0] <= target) {
            dp[0][arr[0]] = 1; 
        }

        for (int i = 1; i < arr.length; i++) {
            for (int sum = 0; sum <= target; sum++) {
                int notTake = dp[i - 1][sum];
                int take = 0;
                if (arr[i] <= sum) {
                    take = dp[i - 1][sum - arr[i]];
                }
                dp[i][sum] = take + notTake;
            }
        }

        return dp[arr.length - 1][target];
    }
}


//recursive -> TLE
class Solution {
    int countPartitions(int[] arr, int d) {
        int total = Arrays.stream(arr).sum();
        if (total < d || (total - d) % 2 != 0) return 0;

        int sum = (total - d) / 2;
        return helper(arr, arr.length-1, sum);
    }
    
    private int helper(int[] arr, int index, int target){
        if(index==0){
            if(target==0 && arr[0]==0) return 2;
            if(target==0 || arr[0]==target) return 1;
            return 0;
        }
        
        int notPick = helper(arr, index-1, target);
        int pick = 0;
        if(arr[index]<=target){
            pick = helper(arr, index-1, target-arr[index]);
        }
        
        return pick+notPick;
    }
}
