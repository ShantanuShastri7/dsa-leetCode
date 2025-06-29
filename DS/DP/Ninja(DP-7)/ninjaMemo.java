// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        int memo[][] = new int[arr.length][arr[0].length+1];
        for(int i=0; i<arr.length; i++){
            Arrays.fill(memo[i], -1);   
        }
        
        return helper(arr, arr[0].length, arr.length-1, memo);
        // return helper(arr, arr[0].length, arr.length-1);
    }
    
    private int helper(int arr[][], int last, int day, int memo[][]){
        int max=0;
        if(day==0){
            for(int i=0; i<arr[0].length; i++){
                if(i!=last){
                    max=Math.max(max,arr[day][i]);
                }
            }
            return max;
        }
        
        if(memo[day][last]!=-1) return memo[day][last];
        
        for(int i=0; i<arr[0].length; i++){
                if(i!=last){
                    max=Math.max(max, arr[day][i]+helper(arr, i, day-1, memo));
                }
        }
        
        return memo[day][last] = max;
        
    }
}
