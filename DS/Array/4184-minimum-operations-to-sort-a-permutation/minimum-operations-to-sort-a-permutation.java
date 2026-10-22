class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int k = -1;

        // Find the index k where element 0 is located
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                k = i;
                break;
            }
        }

        // Case A: Forward Cyclic Shift
        // Check if elements follow [0, 1, ..., n-1] starting from index k
        boolean isForward = true;
        for (int i = 0; i < n; i++) {
            if (nums[(k + i) % n] != i) {
                isForward = false;
                break;
            }
        }

        if (isForward) {
            if (k == 0) return 0; // Already sorted
            return Math.min(k, n - k + 2);
        }

        // Case B: Reverse Cyclic Shift
        // Check if elements follow [0, 1, ..., n-1] in reverse order starting from index k
        boolean isReverse = true;
        for (int i = 0; i < n; i++) {
            if (nums[(k - i + n) % n] != i) {
                isReverse = false;
                break;
            }
        }

        if (isReverse) {
            return Math.min(n - k, k + 2);
        }

        // Neither forward nor reverse cyclic shift
        return -1;
    }
}