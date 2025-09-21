class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;

        int longest = 0;

        for (int i = 1; i < n - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i, right = i;

                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                longest = Math.max(longest, right - left + 1);
            }
        }

        return longest;
    }
}
