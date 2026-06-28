class Solution {
    static boolean canAttend(int[][] arr) {
        // code here
        Arrays.sort(arr, (a,b)->Integer.compare(a[1], b[1]));
        
        int lastEnd = arr[0][1];
        
        for(int i=1; i<arr.length; i++){
            if(lastEnd>arr[i][0]){
                return false;
            }else{
                lastEnd = arr[i][1];
            }
        }
        
        return true;
    }
}
