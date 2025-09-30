class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Orig = Arrays.copyOfRange(nums1, 0, m+1);

        int i=0; 
        int j=0; 
        int pointer=0; 
        while(i<m && j<n){
            if(nums1Orig[i]<=nums2[j]){
                nums1[pointer++]=nums1Orig[i++];
            } else{
                nums1[pointer++]=nums2[j++];
            }
        }

        while(i<m){
            nums1[pointer++]=nums1Orig[i++];
        }
        while(j<n){
            nums1[pointer++]=nums2[j++];
        }
    }
}