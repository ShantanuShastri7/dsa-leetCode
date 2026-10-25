class Solution {
    public int closedIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (!helper(grid, visited, i, j)) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    private boolean helper(int[][] grid, boolean[][] visited, int k, int j) {
        int[][] direcs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        boolean isOnTheEdge = false;

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] { k, j });

        while (!que.isEmpty()) {
            int n = que.size();

            for (int i = 0; i < n; i++) {
                int[] next = que.poll();
                visited[next[0]][next[1]] = true;
                if (next[0] == 0 || next[0] == grid.length-1 || next[1] == 0 || next[1] == grid[0].length-1) {
                    isOnTheEdge = true;
                }

                for (int[] direc : direcs) {
                    int newi = next[0] + direc[0];
                    int newj = next[1] + direc[1];

                    if (newi >= 0 && newi < grid.length && newj >= 0 && newj < grid[0].length && !visited[newi][newj]) {
                        if (grid[newi][newj] == 0) {
                            que.offer(new int[] { newi, newj });
                        }
                    }
                }
            }
        }

        return isOnTheEdge;
    }
}