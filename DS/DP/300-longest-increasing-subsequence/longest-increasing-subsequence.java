class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];

        for(int i=nums.length-1; i>=0; i--){
            for(int j=i-1; j>=-1; j--){
                int notTake = dp[i+1][j+1];
                int take = 0;
                if (j == -1 || nums[i] > nums[j]) {
                    take = 1 + dp[i+1][i+1];
                }

                dp[i][j + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }

    private int helper(int[] nums, int index, int prevIndex, int[][] dp) {
        if (index == nums.length)
            return 0;

        if (dp[index][prevIndex + 1] != -1)
            return dp[index][prevIndex + 1];

        int notTake = helper(nums, index + 1, prevIndex, dp);
        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + helper(nums, index + 1, index, dp);
        }

        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }
}










//Solved on 16/6/26
class Solution {
    static int lis(int arr[]) {
        int[][] mem = new int[arr.length][arr.length+1];
        
        for(int i=0; i<arr.length; i++){
            Arrays.fill(mem[i], -1);
        }
        
        return helper(arr, arr.length-1, arr.length, mem);
        
    }
    
    private static int helper(int arr[], int index, int prevIndex, int mem[][]){
        if(index<0) return 0;
        
        if(mem[index][prevIndex]!=-1) return mem[index][prevIndex];
        
        int pick=0;
        int notPick=0;
        
        if(prevIndex==arr.length || arr[index]<arr[prevIndex]){
            //System.out.print("index: "+arr[index]+" prevIndex: "+arr[prevIndex-1]+"\n");
            pick = 1 + helper(arr, index-1, index, mem);
        }
        
        notPick = helper(arr, index-1, prevIndex, mem);
        
        return mem[index][prevIndex]=Math.max(pick, notPick);
    }
}
