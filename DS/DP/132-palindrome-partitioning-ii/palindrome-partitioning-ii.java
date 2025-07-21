class Solution {
    public int minCut(String s) {
        int dp[] = new int[s.length()+1];
        int n = s.length();
        
        //base case
        dp[n]=0;

        for(int i=n-1; i>=0; i--){
            int minCost = 3000;
            for(int split=i; split<n; split++){
                if(isPalindrome(s.substring(i,split+1))){
                    int cost = 1+dp[split+1];
                    minCost=Math.min(cost, minCost);
                } else continue; 
            }
            dp[i]=minCost;   
        }
        return dp[0]-1;
    }

    // public int minCut(String s) {
    //     int dp[][] = new int[s.length()+1][s.length()+1];
    //     for(int i=0; i<s.length(); i++){
    //         Arrays.fill(dp[i], -1);
    //     }
    //     return helper(s, 0, s.length(), dp)-1;
    // }

    private int helper(String s, int start, int end, int dp[][]){
        if(start==s.length()) return 0;
        int minCost = 3000;
        if(dp[start][end]!=-1) return dp[start][end];

        for(int i=start; i<end; i++){
            if(isPalindrome(s.substring(start,i+1))){
                int cost = 1+helper(s, i+1, end, dp);
                minCost=Math.min(cost, minCost);
            } else continue; 
        }

        return dp[start][end]=minCost;
    }

    private boolean isPalindrome(String s){
        int n = s.length();
        int i=0; int j=n-1;

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i+=1; j-=1; 
        }
        return true;
    }
}