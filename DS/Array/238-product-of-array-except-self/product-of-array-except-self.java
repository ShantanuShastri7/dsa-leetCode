class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        int prod=1;
        int zeroCount=0;
        int withoutZeroProd=1;

        for(int num : nums){
            if(num==0){
                zeroCount++;
                if(zeroCount>1){
                    withoutZeroProd=withoutZeroProd*num;
                }
                prod=prod*num;
            } else{
                withoutZeroProd=withoutZeroProd*num;
                prod=prod*num;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                if(zeroCount<2){
                    result[i]=withoutZeroProd;
                } else{
                    result[i]=0;
                }
            } else{
                result[i]=prod/nums[i];
            }
        }

        return result;
    }
}