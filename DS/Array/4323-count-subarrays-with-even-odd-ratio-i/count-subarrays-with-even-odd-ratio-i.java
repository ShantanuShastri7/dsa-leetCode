class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        //x*b - a*y <=0

        int[] prev = new int[nums.length+1];

        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==0){
                prev[i+1]=prev[i]+b;
            }else{
                prev[i+1]=prev[i]-a;
            }
        }

        int count = 0;


        for(int i = 0; i < prev.length; i++){
            for(int j = i + 1; j < prev.length; j++){
                if(prev[i] >= prev[j]){
                    count++;
                }
            }
        }

        return count;

    }
}