class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int total = n1 + n2;
        int mid1 = (total - 1) / 2;
        int mid2 = total / 2;   

        int i = 0, j = 0, count = 0;
        int curr = 0, prev = 0;

        while (count <= mid2) {
            prev = curr;
            if (i < n1 && (j >= n2 || nums1[i] <= nums2[j])) {
                curr = nums1[i];
                i++;
            } else {
                curr = nums2[j];
                j++;
            }
            count++;
        }

        if (total % 2 == 1) return curr;
        else return (prev + curr) / 2.0;
    }
}