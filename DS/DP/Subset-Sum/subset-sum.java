class Solution {

    public Boolean isSubsetSum(int arr[], int sum) {
        return helper(arr, sum, arr.length-1);
    }
    
    private boolean helper(int arr[], int target, int index){
        if(index==0 && target!=0) return false;
        if(target==0) return true;
        
        boolean notPick = helper(arr, target, index-1);
        boolean pick = false;
        if(target>=arr[index]){
            pick = helper(arr, target-arr[index], index-1);
        }
        
        return pick||notPick;
    }
}
