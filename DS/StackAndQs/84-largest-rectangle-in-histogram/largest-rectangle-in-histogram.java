class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        
        SegmentTree st = new SegmentTree(heights);
        
        return calculateMaxArea(heights, st, 0, heights.length - 1);
    }

    private int calculateMaxArea(int[] heights, SegmentTree st, int left, int right) {
        if (left > right) return 0;

        int minIndex = st.query(0, 0, heights.length - 1, left, right);

        int currentArea = heights[minIndex] * (right - left + 1);
        int maxLeftArea = calculateMaxArea(heights, st, left, minIndex - 1);
        int maxRightArea = calculateMaxArea(heights, st, minIndex + 1, right);

        return Math.max(currentArea, Math.max(maxLeftArea, maxRightArea));
    }
}

class SegmentTree{
    int[] tree;
    int[] heights;

    public SegmentTree(int[] heights){
        this.heights=heights;
        tree = new int[heights.length*4];
        build(0, 0, heights.length-1);
    }

    public void build(int node, int left, int right){
        if(left==right){
            tree[node]=left;
        }else{
            int mid=left +(right-left)/2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            build(leftChild, left, mid);
            build(rightChild, mid + 1, right);

            if (heights[tree[leftChild]] <= heights[tree[rightChild]]) {
                tree[node] = tree[leftChild];
            } else {
                tree[node] = tree[rightChild];
            }
        }
    }

    public int query(int node, int start, int end, int l, int r) {
        if (r < start || l > end) {
            return -1; 
        }

        //query range is completely inside
        if (l <= start && end <= r) {
            return tree[node]; 
        }

        int mid = start + (end - start) / 2;
        int leftIndex = query(2 * node + 1, start, mid, l, r);
        int rightIndex = query(2 * node + 2, mid + 1, end, l, r);

        if (leftIndex == -1) return rightIndex;
        if (rightIndex == -1) return leftIndex;

        return heights[leftIndex] <= heights[rightIndex] ? leftIndex : rightIndex;
    }
}




// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int n = heights.length;
//         int[] leftMost = new int[n];
//         int[] rightMost = new int[n];
//         Stack<Integer> stack = new Stack<>();

//         for (int i = 0; i < n; i++) {
//             leftMost[i] = -1;
//             while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
//                 stack.pop();
//             }
//             if (!stack.isEmpty()) {
//                 leftMost[i] = stack.peek();
//             }
//             stack.push(i);
//         }

//         stack.clear();
//         for (int i = n - 1; i >= 0; i--) {
//             rightMost[i] = n;
//             while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
//                 stack.pop();
//             }
//             if (!stack.isEmpty()) {
//                 rightMost[i] = stack.peek();
//             }
//             stack.push(i);
//         }

//         int maxArea = 0;
//         for (int i = 0; i < n; i++) {
//             leftMost[i] += 1;
//             rightMost[i] -= 1;
//             maxArea = Math.max(maxArea, heights[i] * (rightMost[i] - leftMost[i] + 1));
//         }
//         return maxArea;
//     }
// }