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
