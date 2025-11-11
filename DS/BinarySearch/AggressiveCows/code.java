class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int i=1;
        int j=stalls[stalls.length-1]-stalls[0];
        int result=1;
        
        while(i<=j){
            int mid=(i+j)/2;
            boolean canBeDone = canWePlace(stalls, mid, k);
            
            if(canBeDone){
                result=mid;
                i=mid+1;
            } else{
                j=mid-1;
            }
        }
        return result;
    }
    
    private boolean canWePlace(int[] stalls, int diff, int cows){
        int last=stalls[0];
        cows--;
        for(int i=1; i<stalls.length; i++){
            if(stalls[i]-last>=diff) {
                last=stalls[i];
                cows--;
            }
        }
        
        return cows<=0;
    }
}





#2
    class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int lowest = Integer.MAX_VALUE;
        int high = (stalls[stalls.length-1] - stalls[0]);
        
        for(int i=1; i<stalls.length; i++){
            lowest = Math.min(lowest, (stalls[i]-stalls[i-1]));
        }
        int low = lowest;
        int result = 0;
        
        while(low<=high){
            int middle = (low+high)/2;
            
            if(isPossible(stalls, k, middle)){
                result = middle;
                low = middle+1;
            } else high = middle-1;
        }
        
        return result;
    }
    
    private boolean isPossible(int[] stalls, int k, int dist){
        int i=0;
        int placed=1;
        while(i<stalls.length-1){
            int initialStall=stalls[i];
            while(i<stalls.length-1 && stalls[i+1]-initialStall<dist){
                i++;
            }
            if(i<stalls.length-1) {
                placed++;
                i++;
            }
        }
        
        if(placed>=k) return true;
        else return false;
    }
}
