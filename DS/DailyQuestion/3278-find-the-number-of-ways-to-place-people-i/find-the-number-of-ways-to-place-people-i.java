class Solution {
    public int numberOfPairs(int[][] points) {
        int result = 0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { 
                if ((points[i][0] <= points[j][0] && points[i][1] >= points[j][1]) ||
                    (points[j][0] <= points[i][0] && points[j][1] >= points[i][1])) {
                    
                    if (!checkIfInBetween(i, j, points)) {
                        result++;
                    }
                }
            }
        }

        return result;
    }
    
    private boolean checkIfInBetween(int first, int second, int[][] points) {
        int left = Math.min(points[first][0], points[second][0]);
        int right = Math.max(points[first][0], points[second][0]);
        int bottom = Math.min(points[first][1], points[second][1]);
        int top = Math.max(points[first][1], points[second][1]);

        for (int i = 0; i < points.length; i++) {
            if (i == first || i == second) continue;

            if (points[i][0] >= left && points[i][0] <= right &&
                points[i][1] >= bottom && points[i][1] <= top) {
                return true;
            }
        }
        return false;
    }
}
