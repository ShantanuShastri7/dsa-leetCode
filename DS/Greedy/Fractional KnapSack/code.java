class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        Pair[] pairs = new Pair[val.length];
        
        for(int i=0; i<val.length; i++){
            pairs[i] = new Pair(val[i], wt[i]);
        }
        
        Arrays.sort(pairs, (a, b) -> 
        Float.compare((float) b.first / b.second, (float) a.first / a.second));
        
        double total=0;
        
        for(int i=0; i<pairs.length; i++){
            if(capacity>=pairs[i].second){
                total+=pairs[i].first;
                capacity-=pairs[i].second;
            } else{
                double divisor = (double) capacity/pairs[i].second;
                total += ((double) capacity/pairs[i].second) * (pairs[i].first);
                break;
            }
        }
        
        return total;
    }
    
    static class Pair {
        int first;
        int second;
        
        public Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
}
