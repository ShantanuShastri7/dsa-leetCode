class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drunk = 0;
        int empty = 0;

        while (numBottles > 0) {
            // drink them all
            drunk += numBottles;
            empty += numBottles;

            // exchange
            numBottles = empty / numExchange;
            empty = empty % numExchange;
        }

        return drunk;
    }
}