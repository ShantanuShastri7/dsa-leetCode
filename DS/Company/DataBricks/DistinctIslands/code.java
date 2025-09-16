import java.util.*;

class Solution {
    public int countDistinctIslands(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Set<String> uniqueIslands = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    StringBuilder shape = new StringBuilder();
                    dfs(grid, visited, i, j, i, j, shape);
                    uniqueIslands.add(shape.toString());
                }
            }
        }

        return uniqueIslands.size();
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j, int baseX, int baseY, StringBuilder shape) {
        int rows = grid.length, cols = grid[0].length;
        visited[i][j] = true;

        // Record the relative position to the starting cell
        shape.append((i - baseX)).append(",").append((j - baseY)).append("|");

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];

            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols &&
                !visited[newX][newY] && grid[newX][newY] == 1) {
                dfs(grid, visited, newX, newY, baseX, baseY, shape);
            }
        }
    }
}
