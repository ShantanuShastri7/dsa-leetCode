class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxGreen = 0;
        for (int light : lights) {
            maxGreen = Math.max(maxGreen, light);
        }
        
        int maxPenalty = 0;
        
        for (int time : arrivalTime) {
            int r = time % period;
            
            if (r >= maxGreen) {
                int waitTime = period - r;
                maxPenalty = Math.max(maxPenalty, waitTime);
            }
        }
        
        return maxPenalty;
    }
}