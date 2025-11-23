class Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int left = 0;
        int count = 0;
        int odd = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] % 2 == 1) {
                odd++;
            }

            while (odd > k) {
                if (nums[left] % 2 == 1) {
                    odd--;
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}