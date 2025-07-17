class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);
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
                if((arr[i]%arr[j]==0 || arr[j]%arr[i]==0) && dp[j] + 1 > dp[i]){
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

    private int helper(int[] nums, int index, int prevIndex){
        if(index==nums.length) return 0;

        int notTake = helper(nums, index + 1, prevIndex);
        int take = 0;
        if (prevIndex == -1 || nums[index]%nums[prevIndex]==0 || nums[prevIndex]%nums[index]==0) {
            take = 1 + helper(nums, index + 1, index);
        }

        return Math.max(take, notTake);
    }
}