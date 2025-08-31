class Solution {
    public int median(int[][] mat) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int req = (mat.length * mat[0].length) / 2;

        for (int i = 0; i < mat.length; i++) {
            low = Math.min(low, mat[i][0]); 
            high = Math.max(high, mat[i][mat[0].length - 1]); 
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int lessThan = countLessEqual(mat, mid);

            if (lessThan <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private int countLessEqual(int[][] mat, int num) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            count += upperBound(mat[i], num);
        }
        return count;
    }

    private int upperBound(int[] row, int num) {
        int i = 0, j = row.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (row[mid] <= num) {
                i = mid + 1; 
            } else {
                j = mid - 1;
            }
        }
        return i; 
    }
}
