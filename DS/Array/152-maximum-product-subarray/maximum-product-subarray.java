class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1; 
        int result=Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            prefix*=nums[i];
            suffix*=nums[nums.length-i-1];
            result=Math.max(result, Math.max(prefix, suffix));

            if(nums[i]==0) prefix=1;
            if(nums[nums.length-i-1]==0) suffix=1;
        }

        return result;
    }
}

















// class Solution {
//     public int maxProduct(int[] nums) {
//         int max = Integer.MIN_VALUE;
//         int prod = 1;

//         for (int i = 0; i < nums.length; i++) {
//             prod *= nums[i];
//             max = Math.max(max, prod);
//             if (nums[i] == 0)
//                 prod = 1;
//         }

//         prod = 1;
//         for (int i = nums.length - 1; i >= 0; i--) {
//             prod *= nums[i];
//             max = Math.max(max, prod);
//             if (nums[i] == 0)
//                 prod = 1;
//         }

//         return max;
//     }
// }