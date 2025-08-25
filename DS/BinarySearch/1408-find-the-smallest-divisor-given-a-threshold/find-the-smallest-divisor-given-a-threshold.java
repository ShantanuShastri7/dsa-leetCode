import java.util.*;

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int i = 1; 
        int j = Arrays.stream(nums).max().getAsInt();
        int result = j;   // max possible divisor

        while (i <= j) {
            int mid = (i + j) / 2;
            int sumDivision = getDivisionResult(nums, mid);

            if (sumDivision <= threshold) {
                result = mid;
                j = mid - 1;   
            } else {
                i = mid + 1; 
            }
        }
        return result;
    }

    private int getDivisionResult(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; 
        }
        return sum;
    }
}
