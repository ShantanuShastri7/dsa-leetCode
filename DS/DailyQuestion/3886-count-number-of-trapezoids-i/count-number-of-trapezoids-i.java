class Solution {
    public int countTrapezoids(int[][] points) {
        long MOD = 1_000_000_007;

        // Count frequencies of y-levels
        Map<Integer, Integer> freq = new HashMap<>();
        for (int[] p : points) {
            freq.put(p[1], freq.getOrDefault(p[1], 0) + 1);
        }

        // Compute pairs for each y-level
        ArrayList<Long> combos = new ArrayList<>();
        for (int count : freq.values()) {
            if (count >= 2) {
                long pairs = (1L * count * (count - 1) / 2) % MOD;
                combos.add(pairs);
            }
        }

        if (combos.size() < 2) return 0;

        // DP (prefix sum) approach to compute sum of pairwise products
        long result = 0;
        long prefix = 0;

        for (long c : combos) {
            result = (result + (c * prefix) % MOD) % MOD;
            prefix = (prefix + c) % MOD; // accumulate
        }

        return (int) result;
    }
}