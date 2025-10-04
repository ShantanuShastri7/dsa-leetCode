class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high)
            return 0;

        int mid = (low + high) / 2;

        int left = mergeSort(nums, low, mid);
        int right = mergeSort(nums, mid + 1, high);
        int current = countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);

        return left + right + current;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {
        int ans = 0;

        int left = low;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) nums[i] > 2L * nums[right]) {
                right++;
            }
            ans += (right - (mid + 1));
        }

        return ans;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;

        ArrayList<Integer> ans = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                ans.add(nums[left]);
                left++;
            } else {
                ans.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            ans.add(nums[left]);
            left++;
        }

        while (right <= high) {
            ans.add(nums[right]);
            right++;
        }

        for (int i = 0; i <= high - low; i++) {
            nums[low + i] = ans.get(i);
        }
    }
}