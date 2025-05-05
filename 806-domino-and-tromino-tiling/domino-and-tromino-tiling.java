class Solution {
    public int numTilings(int n) {
        long divisor = (long)Math.pow(10,9) +7;

        if (n==0) return 1;
        else if(n==1) return 1;
        else if(n==2) return 2;

        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i]=(2*dp[i-1]%divisor + dp[i-3]%divisor)%divisor;
        }
        return (int)dp[n];
    }
}