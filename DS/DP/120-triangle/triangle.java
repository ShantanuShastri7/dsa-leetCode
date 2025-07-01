class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int i=0; i<memo[0].length; i++){
            Arrays.fill(memo[i], 10000000);
        }
        return helper(triangle, 0, 0, memo);
    }

    private int helper(List<List<Integer>> triangle, int level, int index, int[][] memo){
        if(level==triangle.size()-1) {
            return triangle.get(level).get(index);
        } 
        if(level>triangle.size()-1 || index>triangle.get(level).size()-1) return 1000000;
        if(memo[level][index]!=10000000) return memo[level][index];

        int minSum=0;
        int below = triangle.get(level).get(index) + helper(triangle, level+1, index, memo);
        int belowAhead = triangle.get(level).get(index) + helper(triangle, level+1, index+1, memo);

        return memo[level][index]=Math.min(below, belowAhead);
    }
}