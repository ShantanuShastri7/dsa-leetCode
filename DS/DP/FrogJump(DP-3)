// User function Template for Java
class Solution {
    int minCost(int[] height) {
        int[] memo = new int[height.length +1];
        Arrays.fill(memo, -1);
        return helper(height, height.length-1, memo);
    }
    
    private int helper(int[] height, int index, int[] memo){
        if(index==0) return 0;
        
        if(memo[index]!=-1) return memo[index];
        
        int sj = Math.abs(height[index]-height[index-1]) + helper(height, index-1, memo);
        int dj = Integer.MAX_VALUE;
        if(index>1){
            dj =  Math.abs(height[index]-height[index-2]) + helper(height, index-2, memo);
        }
        

        return memo[index]=Math.min(sj,dj);
    }
}
