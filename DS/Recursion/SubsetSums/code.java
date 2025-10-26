class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        helper(arr, 0, 0, result);
        return result;
    }
    
    private void helper(int[] arr, int index, int sum, ArrayList<Integer> result) {
        if (index == arr.length) {
            result.add(sum);
            return;
        }
        
        // Exclude current element
        helper(arr, index + 1, sum, result);
        
        // Include current element
        helper(arr, index + 1, sum + arr[index], result);
    }
}
