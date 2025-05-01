class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int score = 0;
        

        for(int[] row: nums){
            Arrays.sort(row);
        }        

        for(int i=m-1; i>=0; i--){
            int max = nums[0][i];
            for(int j=1; j<n; j++){
                if(nums[j][i]>max) max=nums[j][i];
            }
            score+=max;
        }

        return score;
    }
}