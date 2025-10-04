class Solution {
    public int trap(int[] height) {
        int left=0; 
        int right=height.length-1;
        int maxLeft=0; 
        int maxRight=0;
        int res=0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    res += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }

        return res;
    }

    //Pre-Compute
    // public int trap(int[] height) {
    //     int[] dpLeft = new int[height.length];
    //     int[] dpRight = new int[height.length];
    //     int ans=0;

    //     dpLeft[0]=height[0];
    //     for(int i=1; i<height.length; i++){
    //         dpLeft[i]=Math.max(dpLeft[i-1], height[i]);
    //     }

    //     dpRight[height.length-1]=height[height.length-1];
    //     for(int i=height.length-2; i>=0; i--){
    //         dpRight[i]=Math.max(dpRight[i+1], height[i]);
    //     }

    //     for(int i=0; i<height.length; i++){
    //         ans+= Math.min(dpLeft[i], dpRight[i]) - height[i];
    //     }

    //     return ans;
    // }
}