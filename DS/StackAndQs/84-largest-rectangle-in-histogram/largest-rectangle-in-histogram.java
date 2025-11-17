class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int result = 0;

        for(int i = 0; i < heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int idx = st.pop();
                int ht = heights[idx];
                
                int width;
                if (st.isEmpty()) width = i;
                else width = i - (st.peek() + 1);

                result = Math.max(result, ht * width);
            }
            st.push(i);
        }

        int n = heights.length;
        while(!st.isEmpty()){
            int idx = st.pop();
            int ht = heights[idx];

            int width;
            if (st.isEmpty()) width = n;
            else width = n - (st.peek() + 1);

            result = Math.max(result, ht * width);
        }

        return result;
    }
}