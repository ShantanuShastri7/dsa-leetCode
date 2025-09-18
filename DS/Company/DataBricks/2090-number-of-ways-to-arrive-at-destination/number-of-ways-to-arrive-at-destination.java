class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adjacency = new ArrayList<>();
        long[] dist = new long[n];
        long[] ways = new long[n];
        int MOD = 1_000_000_007;

        Arrays.fill(dist, Long.MAX_VALUE);

        for (int i = 0; i < n; i++) adjacency.add(new ArrayList<>());

        for (int[] road : roads) {
            adjacency.get(road[0]).add(new int[]{road[1], road[2]});
            adjacency.get(road[1]).add(new int[]{road[0], road[2]});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});
        dist[0] = 0;
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long tillNowDist = curr[0];
            int target = (int) curr[1];

            if (tillNowDist > dist[target]) continue;

            for (int[] adj : adjacency.get(target)) {
                int next = adj[0];
                int w = adj[1];

                if (tillNowDist + w < dist[next]) {
                    dist[next] = tillNowDist + w;
                    ways[next] = ways[target];
                    pq.offer(new long[]{dist[next], next});
                } else if (tillNowDist + w == dist[next]) {
                    ways[next] = (ways[next] + ways[target]) % MOD;
                }
            }
        }
        return (int) (ways[n - 1] % MOD);
    }
}