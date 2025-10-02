class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drunk=0; 
        int empty=0;

        while(numBottles>0 || empty>numExchange){
            if(numBottles>0){
                drunk+=numBottles;
                empty+=numBottles;
                numBottles=0;
            }

            if(empty>=numExchange){
                numBottles=1;
                empty=empty-numExchange;
                numExchange++;
            }
        }

        return drunk;
    }
}