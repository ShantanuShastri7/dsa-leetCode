import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> res = new ArrayList<>();
        
        int[] currentInterval = intervals[0];
        res.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];
            

            if (currentEnd >= nextBegin) {

                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {

                currentInterval = interval;
                res.add(currentInterval);
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }
}