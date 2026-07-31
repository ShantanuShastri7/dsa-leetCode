class Solution {
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        int gp0=0;
        int gp1=0;
        int gp2=0;
        long res=0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]<a){
                res+=gp1+gp2;
                gp0++;
            } else if(nums[i]>b){
                gp2++;
            } else{
                res+=gp2;
                gp1++;
            }
        }

        return (int)(res % 1000000007);
    }
}