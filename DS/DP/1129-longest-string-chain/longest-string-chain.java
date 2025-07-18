class Solution {
    public int longestStrChain(String[] arr) {
        Arrays.sort(arr, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        int n = arr.length; 
        int[] dp = new int[n];
        int maxi = 1;

        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(compare(arr[i], arr[j]) && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            if(dp[i] > maxi){
                maxi = dp[i];
            }
        }

        return maxi;
    }

    private boolean compare(String a, String b){
        if(b.length()+1 != a.length()) return false;
        int i=0; int j=0;

        while(i<a.length()){
            if(j<b.length() && a.charAt(i)==b.charAt(j)){
                i++; j++;
            } else {
                i++;
            }
        }

        return j==b.length();
    }
}