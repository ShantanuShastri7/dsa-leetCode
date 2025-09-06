import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int ans = 0;

        Arrays.sort(points, Comparator
                .comparingInt((int[] p) -> p[0])
                .thenComparingInt(p -> -p[1]));

        for (int i = 0; i < n - 1; i++) {
            int maxY = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (points[j][1] <= points[i][1] && points[j][1] > maxY) {
                    ans++;
                    maxY = points[j][1];
                }
            }
        }

        return ans;
    }
}