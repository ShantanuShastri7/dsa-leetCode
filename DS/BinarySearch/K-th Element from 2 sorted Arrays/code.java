class Solution {
    public int kthElement(int a[], int b[], int k) {
        int i=Math.max(0, k - b.length);; 
        int j=Math.min(k, a.length);

        while(i<=j){
            int mid = (i+j)/2;
            
            int amountFromRight = k-mid;
            
            int l1 = (mid > 0) ? a[mid - 1] : Integer.MIN_VALUE;
            int l2 = (amountFromRight > 0) ? b[amountFromRight - 1] : Integer.MIN_VALUE;
            int r1 = (mid < a.length) ? a[mid] : Integer.MAX_VALUE;
            int r2 = (amountFromRight < b.length) ? b[amountFromRight] : Integer.MAX_VALUE;
            // System.out.print(" mid: "+mid+" l1: "+l1+" l2: "+l2+" r1: "+r1+" r2: "+r2);
            if(l1>r2){
              j=mid-1;  
            } else if(l2>r1){
                i=mid+1;
            } else {
                return Math.max(l1, l2);
            }
        }
        
        return -1;
        
    }
}
