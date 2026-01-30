class Solution {
    public int maxArea(int[] height) {
        int left=0; 
        int right=height.length-1;
        int result=0;

        while(left<=right){
            int leftH = height[left];
            int rightH = height[right];
            if(leftH<=rightH){
                result = Math.max(result, (right-left)*leftH);
                left++;
            } else {
                result = Math.max(result, (right-left)*rightH);
                right--;
            }
        }

        return result;
    }
}















// public int maxArea(int[] height) {
//         int left=0; 
//         int right=height.length-1;

//         int result = (right-left)*Math.min(height[left],height[right]);

//         while(left<right){
//             if(height[left]<height[right]){
//                 left++;
//                 result = Math.max(result, (right-left)*Math.min(height[left],height[right]));
//             } else {
//                 right--;
//                 result = Math.max(result, (right-left)*Math.min(height[left],height[right]));
//             }
//         }

//         return result;
//     }