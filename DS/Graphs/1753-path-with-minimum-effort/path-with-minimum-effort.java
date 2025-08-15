class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] result = new int[heights.length][heights[0].length];

        for(int i=0; i<heights.length; i++){
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});

         while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int effort = cur[0], r = cur[1], c = cur[2];
            
            if (r == m-1 && c == n-1) return effort;
            if (effort > result[r][c]) continue;
            
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newEffort = Math.max(effort, Math.abs(heights[nr][nc] - heights[r][c]));
                    if (newEffort < result[nr][nc]) {
                        result[nr][nc] = newEffort;
                        pq.offer(new int[]{newEffort, nr, nc});
                    }
                }
            }
        }
        return result[heights.length-1][heights[0].length-1]==Integer.MAX_VALUE?0:result[heights.length-1][heights[0].length-1];
    }
}