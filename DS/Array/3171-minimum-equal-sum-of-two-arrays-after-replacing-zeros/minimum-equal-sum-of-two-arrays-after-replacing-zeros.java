class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1=0;
        long nums1ZeroCount=0;
        long sum2=0;
        long nums2ZeroCount=0;

        for(int num: nums1){
            if(num==0) {
                nums1ZeroCount++;
                sum1++;
            }
            sum1+=num;
        }

        for(int num: nums2){
            if(num==0){ 
                nums2ZeroCount++;
                sum2++;
            }
            sum2+=num;
        }

        if(sum1<sum2 && nums1ZeroCount==0) return -1;
        if(sum2<sum1 && nums2ZeroCount==0) return -1;

        if(sum1<sum2){
            return sum2;
        } else if(sum1>sum2){
            return sum1;
        } else {
            return sum1;
        }
    }
}