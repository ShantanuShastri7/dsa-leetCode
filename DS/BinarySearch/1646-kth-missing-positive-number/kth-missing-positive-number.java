class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i=0; 
        int j=arr.length-1;
        int result=0;

        while(i<=j){
            int mid=(i+j)/2;
            int missing=arr[mid]-mid-1;

            if(missing<k) i=mid+1;
            else {
                j=mid-1;
            }
        }
        if (j == -1) {
            return k; 
        }
        return arr[j]+(k-(arr[j]-j-1));
    }
}