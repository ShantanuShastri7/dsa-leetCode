import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1; 
        int j = Arrays.stream(piles).max().getAsInt();
        int result = j;

        while (i <= j) {
            int mid = (i + j) / 2;
            int hrs = timeRequired(piles, mid, h);

            if (hrs <= h) {
                result = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return result;
    }

    private int timeRequired(int[] piles, int perHr, int h) {
        int count = 0;
        for (int pile : piles) {
            count += (pile + perHr - 1) / perHr;
            if (count > h) return count;
        }
        return count;
    }
}
