class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n][n];
        for (int[] row : result) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        result[0][0] = grid[0][0];

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int timeTillNow = node[0];
            int i = node[1];
            int j = node[2];

            if (i == n-1 && j == n-1) return timeTillNow;

            for (int[] d : dirs) {
                int ni = i + d[0];
                int nj = j + d[1];

                if (ni>=0 && nj>=0 && ni<n && nj<n) {
                    int newTime = Math.max(timeTillNow, grid[ni][nj]);
                    if (newTime < result[ni][nj]) {
                        result[ni][nj] = newTime;
                        pq.offer(new int[]{newTime, ni, nj});
                    }
                }
            }
        }
        return -1;
    }
}