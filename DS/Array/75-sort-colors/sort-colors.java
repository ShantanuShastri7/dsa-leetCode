class Solution {
    //low = first 1
    //mid = first unsorted index
    //high = last unsorted index
    public void sortColors(int[] nums) {
        int low=0; 
        int mid=0; 
        int high = nums.length-1;

        while(mid<=high){
            if(nums[mid]==1){
                mid++;
            } else if(nums[mid]==0){
                int temp = nums[low];
                nums[low]=0;
                nums[mid]=temp;
                low++;
                mid++;
            } else {
                int temp = nums[high];
                nums[high]=2;
                nums[mid]=temp;
                high--;
            }
        }
    }
}