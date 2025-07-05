
class Solution {
    int countPartitions(int[] arr, int d) {
        int total = Arrays.stream(arr).sum();
        if (total < d || (total - d) % 2 != 0) return 0;

        int sum = (total - d) / 2;
        return helper(arr, arr.length-1, sum);
    }
    
    private int helper(int[] arr, int index, int target){
        if(index==0){
            if(target==0 && arr[0]==0) return 2;
            if(target==0 || arr[0]==target) return 1;
            return 0;
        }
        
        int notPick = helper(arr, index-1, target);
        int pick = 0;
        if(arr[index]<=target){
            pick = helper(arr, index-1, target-arr[index]);
        }
        
        return pick+notPick;
    }
}
