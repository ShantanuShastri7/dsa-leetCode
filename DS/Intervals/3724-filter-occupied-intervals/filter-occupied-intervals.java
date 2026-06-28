class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        int n = occupiedIntervals.length;
        Arrays.sort(occupiedIntervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int[] currentPeriod = new int[] { occupiedIntervals[0][0], occupiedIntervals[0][1] };
        result.add(currentPeriod);

        for (int i = 1; i < n; i++) {
            int currentEnd = currentPeriod[1];
            int newStart = occupiedIntervals[i][0];
            int newEnd = occupiedIntervals[i][1];

            if (currentEnd+1 >= newStart) {
                currentEnd = Math.max(currentEnd, newEnd);
                result.get(result.size() - 1)[1] = currentEnd;
            } else {
                currentPeriod = new int[] { occupiedIntervals[i][0], occupiedIntervals[i][1] };
                result.add(currentPeriod);
            }
        }

        List<List<Integer>> finalRes = new ArrayList<>();

        for (int[] interval : result) {
            int start = interval[0];
            int end = interval[1];

            // Case 1: No overlap at all. It's either entirely before or entirely after.
            if (end < freeStart || start > freeEnd) {
                finalRes.add(Arrays.asList(start, end));
            }
            // Case 2: Overlap exists. We check the left and right surviving boundaries.
            else {
                // Is there a surviving left piece?
                if (start < freeStart) {
                    finalRes.add(Arrays.asList(start, freeStart - 1));
                }

                // Is there a surviving right piece?
                if (end > freeEnd) {
                    finalRes.add(Arrays.asList(freeEnd + 1, end));
                }
            }
        }
        return finalRes;
    }
}