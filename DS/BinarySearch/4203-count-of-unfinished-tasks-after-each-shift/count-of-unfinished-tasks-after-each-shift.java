class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        int m = shifts.length;
        int[] res = new int[m];
        
        long[] prev = new long[n + 1];
        for(int i = 0; i < n; i++){
            prev[i + 1] = prev[i] + tasks[i];
        }
        
        long currentAbsoluteTime = 0;
        
        for(int i = 0; i < m; i++){
            currentAbsoluteTime += shifts[i];
            
            int tillWhere = tillWhere(prev, currentAbsoluteTime);
    
            if(tillWhere == n){
                res[i] = 0;
                
                currentAbsoluteTime = 0; 
            } else {
                res[i] = n - tillWhere;
            }
        }
        
        return res;
    }

    private int tillWhere(long[] prev, long time){
        int l = 0;
        int r = prev.length - 1;
        int res = 0;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(prev[mid] <= time){
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }
}