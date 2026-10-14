class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] num = new long[nums.length];

        for(int i=0; i<nums.length; i++){
            num[i]=(long)Math.pow(nums[i], 2);
        }

        Arrays.sort(num);
        long res=0;

        int start=0;
        int end=num.length-1;

        while(start<end){
            res+=(long)num[end];
            res-=(long)num[start];
            start++;
            end--;
        }

        if(num.length%2==1){
            res+=(long)num[end];
        }

        return res;
    }
}