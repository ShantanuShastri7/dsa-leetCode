class Solution {
    public boolean winnerSquareGame(int n) {
        ArrayList<Integer> sqs = howManySqs(n);
        Boolean[] dp = new Boolean[n+1];

        boolean res = helper(n, dp, sqs);

        if(res) return true;

        return false;
    }

    private boolean helper(int n, Boolean[] dp, ArrayList<Integer> sqs){
        if(n==0){
            return false;
        }
        if(dp[n]!=null) return dp[n];

        for(int i : sqs){
            boolean res;
            if(i<=n){
                res = helper(n-i, dp, sqs);
                if(!res) {
                    dp[n]= true;
                    return true;
                }
            }
        }
        dp[n]=false;
        return false;
    }

    private ArrayList<Integer> howManySqs(int n){
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=1; i<=n; i++){
            int x = (int) Math.sqrt(i);
            if(x*x==i) res.add(i);
        }

        return res;
    }
}