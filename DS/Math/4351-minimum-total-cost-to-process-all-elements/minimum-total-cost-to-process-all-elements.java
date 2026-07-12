class Solution {
    public int minimumCost(int[] nums, int k) {
        long MOD = 1000000007;
        long cost = 0;
        long powerUps = 1;
        long power = k;
        
        for (int n : nums) {
            long num = n; // Convert to long to prevent overflow
            
            if (power < num) {
                long needed = num - power;
                // Ceiling division to find exactly how many times we need to add 'k'
                long ops = (needed + k - 1) / k; 
                
                // Calculate arithmetic progression sum modulo 10^9 + 7
                long opsMod = ops % MOD;
                long powerUpsMod = powerUps % MOD;
                
                // term1 = ops * powerUps
                long term1 = (opsMod * powerUpsMod) % MOD;
                
                // term2 = ops * (ops - 1) / 2
                // We use 500000004L because it is the modular inverse of 2 under modulo 10^9 + 7
                long term2 = (opsMod * ((ops - 1) % MOD) % MOD * 500000004L) % MOD;
                
                long addedCost = (term1 + term2) % MOD;
                cost = (cost + addedCost) % MOD;
                
                // Update our trackers
                powerUps += ops;
                power += ops * (long)k;
            }
            // Pay the resource cost
            power -= num;
        }
        
        return (int) cost;
    }
}