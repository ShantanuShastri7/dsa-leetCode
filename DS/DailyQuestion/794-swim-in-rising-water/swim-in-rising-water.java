class Solution {
    public int swimInWater(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = grid[0][0];

        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));

        pq.add(new ArrayList<>(Arrays.asList(grid[0][0], 0, 0)));

        while (!pq.isEmpty()) {
            ArrayList<Integer> node = pq.poll();
            Integer currentTime = node.get(0);
            Integer currentX = node.get(1);
            Integer currentY = node.get(2);

            if (currentX == grid.length - 1 && currentY == grid[0].length - 1)
                return currentTime;

            int[][] dxdy = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

            for (int[] dx : dxdy) {
                int newX = currentX + dx[0];
                int newY = currentY + dx[1];

                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                    int currentMaxTime = Math.max(currentTime, grid[newX][newY]);
                    if(currentMaxTime<dp[newX][newY]){
                        dp[newX][newY] = currentMaxTime;
                        pq.add(new ArrayList<>(Arrays.asList(currentMaxTime, newX, newY)));
                    }
                }
            }
        }

        return -1;
    }
}