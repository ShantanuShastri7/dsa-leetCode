class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });

        int eraseCount = 0;
        int currentEndTime = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // If the next interval starts BEFORE the current one ends, it's an overlap.
            if (intervals[i][0] < currentEndTime) {
                // Throw it away!
                eraseCount++;
            } else {
                // No overlap. We keep it, and it becomes our new benchmark.
                currentEndTime = intervals[i][1];
            }
        }

        return eraseCount;
    }
}