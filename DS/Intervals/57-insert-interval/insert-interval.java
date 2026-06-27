class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0) return intervals; 
        if (intervals.length == 0) return new int[][]{newInterval};

        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }
        
        int newIntervalStart = newInterval[0];
        int newIntervalEnd = newInterval[1];
        
        while (i < n && intervals[i][0] <= newIntervalEnd) {
            newIntervalStart = Math.min(newIntervalStart, intervals[i][0]);
            newIntervalEnd = Math.max(newIntervalEnd, intervals[i][1]);
            i++;
        }

        res.add(Arrays.asList(newIntervalStart, newIntervalEnd));

        while (i < n) {
            res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }

        int[][] answer = new int[res.size()][2];
        for (int v = 0; v < res.size(); v++) {
            answer[v][0] = res.get(v).get(0);
            answer[v][1] = res.get(v).get(1);
        }

        return answer;
    }
}