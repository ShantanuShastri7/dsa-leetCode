import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (n == 0 || grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        int[][] distance = new int[n][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>(
        //     (a, b) -> a.getKey() - b.getKey()
        // );

        Queue<Pair<Integer, Pair<Integer, Integer>>> pq = new LinkedList<>();

        pq.offer(new Pair<>(1, new Pair<>(0, 0)));
        distance[0][0] = 1;

        while (!pq.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> node = pq.poll();
            int dist = node.getKey();
            int x = node.getValue().getKey();
            int y = node.getValue().getValue();

            if (x == n - 1 && y == n - 1) return dist; 

            for (int k = 0; k < 8; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                    if (dist + 1 < distance[newX][newY]) {
                        distance[newX][newY] = dist + 1; 
                        pq.offer(new Pair<>(dist + 1, new Pair<>(newX, newY)));
                    }
                }
            }
        }
        return -1; 
    }
}
