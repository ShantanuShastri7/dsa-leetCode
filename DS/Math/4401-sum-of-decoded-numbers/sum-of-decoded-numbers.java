class Solution {
    public int sumDecoded(long[] nums) {
        int MOD = 1_000_000_007;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];

            int width = (int) (num % 10);

            long d = num / 10;

            String numS = String.valueOf(d);
            long x = Long.parseLong(numS.substring(0, width));
            long y = Long.parseLong(numS.substring(width));

            int power = modPow(x, y);

            res = (res + power) % MOD;
        }

        return res;
    }

    private int modPow(long base, long exp) {
    long result = 1;
    long mod = 1_000_000_007;
    
    base = base % mod; // Just in case base is already > mod
    
    while (exp > 0) {
        // If the current exponent is odd, multiply the result by base
        if (exp % 2 == 1) {
            result = (result * base) % mod;
        }
        // Square the base and halve the exponent
        base = (base * base) % mod;
        exp /= 2;
    }
    
    return (int) result;
}
}