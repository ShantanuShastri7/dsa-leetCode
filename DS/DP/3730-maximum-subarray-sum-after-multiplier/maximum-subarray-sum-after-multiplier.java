class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long MIN = (long) -1e15; 
        
        long phase0 = MIN, phase1 = MIN, phase2 = MIN;
        long maxMul = MIN;
        
        for (int val : nums) {
            long i = (long) val;
            long op = i * k;
            
            long prev0 = phase0;
            long prev1 = phase1;

            phase0 = Math.max(prev0 + i, i);
            phase1 = Math.max(prev0 + op, Math.max(prev1 + op, op));
            phase2 = Math.max(prev1 + i, phase2 + i);
            
            maxMul = Math.max(maxMul, Math.max(phase0, Math.max(phase1, phase2)));
        }

        phase0 = MIN; phase1 = MIN; phase2 = MIN;
        long maxDiv = MIN;
        
        for (int val : nums) {
            long i = (long) val;
            long op = i / k; 
            
            long prev0 = phase0;
            long prev1 = phase1;
            
            phase0 = Math.max(prev0 + i, i);
            phase1 = Math.max(prev0 + op, Math.max(prev1 + op, op));
            phase2 = Math.max(prev1 + i, phase2 + i);
            
            maxDiv = Math.max(maxDiv, Math.max(phase0, Math.max(phase1, phase2)));
        }

        return Math.max(maxMul, maxDiv);
    }
}