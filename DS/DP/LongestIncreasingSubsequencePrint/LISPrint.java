class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        int n = arr.length; 
        int[] dp = new int[n];
        int[] hash = new int[n];
        int lastIndex = 0;
        int maxi = 1;

        for(int i = 0; i < n; i++){
            dp[i] = 1;
            hash[i] = i;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if(dp[i] > maxi){
                maxi = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(arr[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            lis.add(arr[lastIndex]);
        }

        Collections.reverse(lis);
        return lis;
    }
}
