class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int left = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        int count = matrix.length * matrix[0].length;

        List<Integer> result = new ArrayList<>();
        int counter = 0;

        while (counter < count) {
            // Traverse top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
                counter++;
                if(counter==count) break;
            }
            if(counter==count) break;
            top++;

            // Traverse right column (FIXED)
            for (int j = top; j <= bottom; j++) {
                result.add(matrix[j][right]); 
                counter++;
                if(counter==count) break;
            }
            if(counter==count) break;
            right--;

            // Traverse bottom row
            for (int k = right; k >= left; k--) {
                result.add(matrix[bottom][k]);
                counter++;
                if(counter==count) break;
            }
            if(counter==count) break;
            bottom--;

            // Traverse left column (FIXED)
            for (int l = bottom; l >= top; l--) {
                result.add(matrix[l][left]); 
                counter++;
                if(counter==count) break;
            }
            if(counter==count) break;
            left++;
        }

        return result;
    }
}