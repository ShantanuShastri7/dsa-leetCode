class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) adj[e[0]].add(new int[]{e[1], e[2]});

        int[][] dist = new int[n][k + 1];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        // PQ stores: {totalWeight, currentNode, consecutiveCount}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Starting at node 0 with 1 consecutive char (the label of node 0 itself)
        dist[0][1] = 0;
        pq.add(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int w = curr[0], u = curr[1], count = curr[2];

            if (w > dist[u][count]) continue;
            if (u == n - 1) return w;

            for (int[] edge : adj[u]) {
                int v = edge[0], weight = edge[1];
                int nextCount = (labels.charAt(v) == labels.charAt(u)) ? count + 1 : 1;

                if (nextCount <= k && w + weight < dist[v][nextCount]) {
                    dist[v][nextCount] = w + weight;
                    pq.add(new int[]{dist[v][nextCount], v, nextCount});
                }
            }
        }

        return -1;
    }
}