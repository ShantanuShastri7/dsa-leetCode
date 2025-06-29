class Solution {
    
    public int maximumPoints(int arr[][]) {
        int[] dp = new int[4];
        
        dp[0] = Math.max(arr[0][1], arr[0][2]);
        dp[1] = Math.max(arr[0][0], arr[0][2]);
        dp[2] = Math.max(arr[0][0], arr[0][1]);    
        dp[3] = Math.max(arr[0][0], Math.max(arr[0][1],arr[0][2]));
        
        for(int day=1; day<arr.length; day++){
            int[] temp = new int[4];
            for(int last=0; last<4; last++){
                for(int task=0; task<3; task++){
                    if(task!=last){
                        int point = arr[day][task] + dp[task];
                        temp[last]=Math.max(temp[last], point);
                    }
                }
            }
            dp=temp;
        }
        return dp[3];
    }
}
