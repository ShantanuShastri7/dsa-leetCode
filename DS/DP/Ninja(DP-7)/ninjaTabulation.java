class Solution {
    
    public int maximumPoints(int arr[][]) {
        int dp[][] = new int[arr.length][4];
        
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);    
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1],arr[0][2]));
        
        for(int day=1; day<arr.length; day++){
            for(int last=0; last<4; last++){
                dp[day][last]=0;
                for(int task=0; task<3; task++){
                    if(task!=last){
                        int point = arr[day][task] + dp[day-1][task];
                        dp[day][last]=Math.max(dp[day][last], point);
                    }
                }
            }
        }
        return dp[arr.length-1][3];
    }
}
