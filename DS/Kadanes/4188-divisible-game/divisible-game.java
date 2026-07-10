class Solution {
    public int divisibleGame(int[] nums) {
        Set<Integer> allCandidateK = new HashSet<>();

        for (int num : nums) {
            allCandidateK.addAll(getUniquePrimeFactors(num));
        }
        
        if (allCandidateK.isEmpty()) {
            allCandidateK.add(2);
        }

        long maxScore = Long.MIN_VALUE;
        long bestK = Long.MAX_VALUE;

        for (long k : allCandidateK) {
            long currentSum = 0;
            long currentMaxScore = Long.MIN_VALUE;
            
            // Kadane's Algorithm
            for (int i = 0; i < nums.length; i++) {
                long val = (nums[i] % k == 0) ? nums[i] : -nums[i];
                
                currentSum = Math.max(val, currentSum + val);
                currentMaxScore = Math.max(currentMaxScore, currentSum);
            } 

            if (currentMaxScore > maxScore) {
                maxScore = currentMaxScore;
                bestK = k;
            } else if (currentMaxScore == maxScore) {
                bestK = Math.min(bestK, k);
            }
        }

        long MOD = 1_000_000_007;
        long product = (maxScore % MOD) * (bestK % MOD);
        
        return (int) (((product % MOD) + MOD) % MOD);
    }

    public static Set<Integer> getUniquePrimeFactors(int n) {
        Set<Integer> primeFactors = new HashSet<>();

        while (n % 2 == 0) {
            primeFactors.add(2);
            n /= 2;
        }

        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }

        if (n > 1) {
            primeFactors.add(n);
        }

        return primeFactors;
    }
}