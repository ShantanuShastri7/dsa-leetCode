class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Phase 1: Add all intervals that come completely BEFORE the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // Phase 2: Merge all overlapping intervals into the newInterval itself
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the final, fully-merged new interval
        res.add(newInterval); 

        // Phase 3: Add all remaining intervals that come completely AFTER
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        // Convert the ArrayList back to a 2D array
        return res.toArray(new int[res.size()][]);
    }
}