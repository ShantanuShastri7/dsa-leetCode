class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxArea = 0;

        while(left<right){
            if(height[left]<=height[right]){
                maxArea = Math.max(maxArea, (right-left)*height[left]);
                left++;
            } else{
                maxArea = Math.max(maxArea, (right-left)*height[right]);
                right--;
            }
        }

        return maxArea;
    }
}

//The below solution ignores the width and just accounts for the longest bars left and right, this can be used to solve the Trappping Rain Water problem
// class Solution {
//     public int maxArea(int[] height) {
//         int n = height.length;
//         ArrayList<int[]> greatestLeft = new ArrayList<>(); 
//         ArrayList<int[]> greatestRight = new ArrayList<>();
//         greatestLeft.add(new int[]{0, height[0]});
//         greatestRight.add(new int[]{n-1, height[n-1]});

//         for(int i=1; i<n; i++){
//             int index = greatestLeft.get(i-1)[1]>height[i]?greatestLeft.get(i-1)[0]:i;
//             greatestLeft.add(new int[]{index, Math.max(greatestLeft.get(i-1)[1], height[i])});
//         }

//         for(int i=n-2; i>=0; i--){
//             int index = greatestRight.get(n-i-2)[1]>height[i]?greatestRight.get(n-i-2)[0]:i;
//             greatestRight.add(new int[]{index, Math.max(greatestRight.get(n-i-2)[1], height[i])});
//         }

//         int result =0;

//         for(int i=0; i<n; i++){
//             int indexLeft = greatestLeft.get(i)[0];
//             int valueLeft = greatestLeft.get(i)[1];
//             int indexRight = greatestRight.get(n-i-1)[0];
//             int valueRight = greatestRight.get(n-i-1)[1];
//             System.out.print("indexLeft: "+indexLeft + " indexRight: "+indexRight + " valueLeft: "+valueLeft + " valueRIght: " + valueRight + "\n");
//             result = Math.max(result, (indexRight-indexLeft)*Math.min(valueLeft, valueRight));
//         }

//         return result;
//     }
// }