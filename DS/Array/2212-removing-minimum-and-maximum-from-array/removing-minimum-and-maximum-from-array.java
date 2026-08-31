class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length ==1) return 1;
        int n = nums.length;
        int minIndex=0;
        int maxIndex=0;
        int[] nums1 = nums.clone();

        Arrays.sort(nums1);
        int min = nums1[0];
        int max = nums1[n-1];

        boolean maxInWayOfMin=false;
        boolean minInWayOfMax=false;

        int i=0;
        while(nums[i]!=min){
            i++;
        }
        minIndex=i;

        i=n-1;
        while(nums[i]!=max){
            i--;
        }
        maxIndex=i;

        if(minIndex<maxIndex){
            int leftDelete = maxIndex+1;
            int rightDelete = n-minIndex;
            int bothSides = minIndex+1+(n-maxIndex);

            return Math.min(leftDelete, Math.min(rightDelete, bothSides));
        }else{
            int leftDelete = minIndex+1;
            int rightDelete = n-maxIndex;
            int bothSides = maxIndex+1+(n-minIndex);

            return Math.min(leftDelete, Math.min(rightDelete, bothSides));
        }
    }
}