class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] preMum = new int[nums.length];
        int[] sufMum = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            if(i==0){
                preMum[i]=nums[i];
                sufMum[nums.length-1]=nums[nums.length-1];
            }else{
                preMum[i]=preMum[i-1]*nums[i];
                sufMum[nums.length-i-1]=sufMum[nums.length-i]*nums[nums.length-i-1];
            }
        }

        int[] res = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int left = i>0?preMum[i-1]:1;
            int right = i<nums.length-1?sufMum[i+1]:1;

            res[i]=left*right;
        }

        return res;
    }
}