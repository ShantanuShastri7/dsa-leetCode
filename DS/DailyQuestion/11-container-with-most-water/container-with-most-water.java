class Solution {
    public int maxArea(int[] height) {
        int left=0; 
        int right=height.length-1;

        int result = (right-left)*Math.min(height[left],height[right]);

        while(left<right){
            if(height[left]<height[right]){
                left++;
                result = Math.max(result, (right-left)*Math.min(height[left],height[right]));
            } else {
                right--;
                result = Math.max(result, (right-left)*Math.min(height[left],height[right]));
            }
        }

        return result;
    }
}