class Solution {
    public int minSwaps(int[] nums) {
        int[][] numsNew = new int[nums.length][3];

        for (int i = 0; i < nums.length; i++) {
            numsNew[i][0] = nums[i];
            numsNew[i][1] = sumOfDigits(nums[i]);
            numsNew[i][2] = i;
        }

        Arrays.sort(numsNew, (a, b) -> {
            if (a[1] < b[1])
                return -1;
            else if (a[1] > b[1])
                return 1;
            else {
                if (a[0] < b[0])
                    return -1;
                else
                    return 1;
            }
        });

        int swaps = 0;
        boolean[] visited = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || numsNew[i][2] == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = numsNew[j][2]; 
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    private int sumOfDigits(int num) {
        int res = 0;

        while (num > 0) {
            res += num % 10;
            num /= 10;
        }

        return res;
    }
}