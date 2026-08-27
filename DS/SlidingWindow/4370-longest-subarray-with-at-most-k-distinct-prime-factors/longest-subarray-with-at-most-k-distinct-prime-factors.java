class Solution {
    public int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        int l=0;

        for (int r = 0; r < nums.length; r++) {

            Set<Integer> primes = getPrimeFactors(nums[r]); 
            for (int i : primes) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            while (l <= r && map.size() > k) {
                Set<Integer> primesToRemove = getPrimeFactors(nums[l]);
                for (int i : primesToRemove) {
                    map.put(i, map.get(i) - 1);
                    if (map.get(i) == 0) {
                        map.remove(i);
                    }
                }
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    private Set<Integer> getPrimeFactors(int n) {
        Set<Integer> factors = new HashSet<>();

        // Step 1: Catch all the 2s (this allows us to skip even numbers later)
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // Step 2: Check odd numbers starting from 3 up to the square root of n
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, add i and divide n
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // Step 3: If n is a prime number greater than 2, it will be left over
        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }
}