class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==1 && matrix[0].length==1) return matrix[0][0]==target;
        int i=0; 
        int j=matrix.length-1;
        int rowNum=-1;

        while(i<=j){
            int mid = (i+j)/2;

            if(matrix[mid][0]>target){
                j=mid-1;
            } else if(matrix[mid][0]<target){
                rowNum=mid;
                i=mid+1;
            } else return true;
        }
        if(rowNum==-1) return false;

        int[] row = matrix[rowNum];

        i=0; 
        j=matrix[0].length-1;

        while(i<=j){
            int mid = (i+j)/2;

            if(row[mid]<target){
                i=mid+1;
            } else if(row[mid]>target){
                j=mid-1;
            } else return true;
        }

        return false;
    }
}