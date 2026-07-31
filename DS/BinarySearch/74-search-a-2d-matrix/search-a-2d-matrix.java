class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int top=0;
        int down=matrix.length-1;
        int mid=0;
        int res=0;
        while(top<=down){
            mid=top+(down-top)/2;

            if(matrix[mid][0]>target){
                down=mid-1;
            }else{
                top=mid+1;
                res=mid;
            }
        }

        int left=0;
        int right=matrix[0].length-1;
        int rowMid=0;
        int res2=0;
        while(left<=right){
            rowMid=left+(right-left)/2;

            if(matrix[res][rowMid]>target){
                right=rowMid-1;
            }else{
                left=rowMid+1;
                res2=rowMid;
            }
        }

        if(matrix[res][res2]==target) return true;

        return false;
    }
}