class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(i==sumOfNUms(nums[i])) return i;
        }

        return -1;
    }
    private int sumOfNUms(int i){
        int res=0;

        while(i!=0){
            res+=i%10;
            i/=10;
        }


        return res;
    }
}