class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i : prices){
            if(i<min){
                min=i;
                max=i;
            }
            if(i>max){
                max=i;
                res=Math.max(res, max-min);
            }
        }

        return res;
        
    }
}