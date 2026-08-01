class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n) / 2;
        
        int i = 0;
        int j = 0;
        int curr = 0;
        int prev = 0;

        // We need exactly 'mid + 1' steps to reach the median(s)
        for (int count = 0; count <= mid; count++) {
            prev = curr; // Save the last value before we move forward
            
            // Move 'i' if: nums1 has elements AND (nums2 is empty OR nums1 has the smaller element)
            if (i < m && (j == n || nums1[i] < nums2[j])) {
                curr = nums1[i];
                i++;
            } else {
                // Otherwise, move 'j'
                curr = nums2[j];
                j++;
            }
        }

        // Fix the math precedence and return the correct variables
        if ((m + n) % 2 == 0) {
            return (prev + curr) / 2.0;
        } else {
            return curr;
        }
    }
}












// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int n1 = nums1.length, n2 = nums2.length;
//         int total = n1 + n2;
//         int mid1 = (total - 1) / 2;
//         int mid2 = total / 2;   

//         int i = 0, j = 0, count = 0;
//         int curr = 0, prev = 0;

//         while (count <= mid2) {
//             prev = curr;
//             if (i < n1 && (j >= n2 || nums1[i] <= nums2[j])) {
//                 curr = nums1[i];
//                 i++;
//             } else {
//                 curr = nums2[j];
//                 j++;
//             }
//             count++;
//         }

//         if (total % 2 == 1) return curr;
//         else return (prev + curr) / 2.0;
//     }
// }