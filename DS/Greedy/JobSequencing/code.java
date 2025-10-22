class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        Pair[] pairs = new Pair[deadline.length];
        
        for(int i=0; i<deadline.length; i++){
            pairs[i] = new Pair(deadline[i], profit[i]);
        }
        
        Arrays.sort(pairs, (a,b)->{
            return b.second-a.second;
        });
        
        int maxDeadline = Arrays.stream(deadline).max().getAsInt();
        
        int[] done = new int[maxDeadline+1];
        Arrays.fill(done, -1);
        int count=0;
        int totalProfit=0;
        
        for(int i=0; i<pairs.length; i++){
            int dead = pairs[i].first;
            int prof = pairs[i].second;
            
            while(dead>0){
                if(done[dead]==-1){
                    done[dead]=1;
                    count++;
                    totalProfit+=prof;
                    break;
                } else{
                    dead--;
                }
            }
        }
        
        return new ArrayList<>(Arrays.asList(count, totalProfit));
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
