import java.util.*;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int i = Arrays.stream(weights).max().getAsInt();   // minimum capacity
        int j = Arrays.stream(weights).sum();              // maximum capacity
        int result = j;

        while (i <= j) {
            int mid = (i + j) / 2;
            int daysRequired = calculateDays(weights, mid);

            if (daysRequired <= days) {
                result = mid;   // candidate answer
                j = mid - 1;   // try smaller capacity
            } else {
                i = mid + 1;   // need larger capacity
            }
        }
        return result;
    }

    private int calculateDays(int[] weights, int capacity) {
        int days = 1;   // at least one day
        int load = 0;

        for (int weight : weights) {
            load += weight;
            if (load > capacity) {  // exceed capacity → new day
                days++;
                load = weight;
            }
        }
        return days;
    }
}
