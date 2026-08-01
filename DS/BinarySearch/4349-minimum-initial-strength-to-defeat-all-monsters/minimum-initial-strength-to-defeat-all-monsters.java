class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        
        // Fix 3: Use long[] to prevent overflow of combined overlapping boosts
        // We make the difference array size n + 1 to easily handle the right boundary
        long[] diff = new long[n + 1];

        // Fix 1: Use a Difference Array to apply boosts in O(B) time
        for (int[] b : boosts) {
            int left = b[0];
            int right = b[1];
            int val = b[2];
            
            diff[left] += val;
            diff[right + 1] -= val;
        }

        long[] avaiBoost = new long[n];
        long currentBoost = 0;
        for (int i = 0; i < n; i++) {
            currentBoost += diff[i];
            avaiBoost[i] = currentBoost;
        }

        long min=0;
        long max = Arrays.stream(monsters).asLongStream().sum();
        long res=0;
        while(min<=max){
            long mid = min+(max-min)/2;

            if(helper(monsters, avaiBoost, mid)){
                max=mid-1;
                res=mid;
            }else{
                min=mid+1;
            }
        }

        return res;
        
    }

    private boolean helper(int[] monsters, long[] boosts, long start){
        for(int i=0; i<monsters.length; i++){
            if(start>=monsters[i]){
                start-=monsters[i];
            } else if(start+boosts[i]>=monsters[i]){
                start=0;
            }else return false;
        }

        return true;
    }
}