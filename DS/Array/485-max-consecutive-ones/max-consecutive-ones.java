class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOne = 0;
        int current = 0;

        for (int n : nums) {
            if (n == 1) {
                current++;
                maxOne = Math.max(maxOne, current);
            } else {
                current = 0;
            }
        }

        return maxOne;
    }
}