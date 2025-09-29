class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        // Find first decreasing element from the end
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // If not found, reverse the entire array
        if (index == -1) {
            for (int i = 0, j = n - 1; i < j; i++, j--) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            return;
        }

        // Find the element just larger than nums[index] from the end
        int swapIndex = -1;
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swapIndex = i;
                break;
            }
        }

        // Swap
        int temp = nums[index];
        nums[index] = nums[swapIndex];
        nums[swapIndex] = temp;

        // Reverse the suffix
        for (int i = index + 1, j = n - 1; i < j; i++, j--) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}