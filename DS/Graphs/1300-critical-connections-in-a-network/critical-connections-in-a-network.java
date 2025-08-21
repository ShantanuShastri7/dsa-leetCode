class Solution {
    int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adjacency = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int[] visited = new int[n];
        int[] lows = new int[n];
        int[] time = new int[n];

        for (int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjacency.get(u).add(v);
            adjacency.get(v).add(u);
        }

        dfs(adjacency, 0, -1, lows, time, result, visited);

        return result;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adjacency, int target, int parent,
                     int[] lows, int[] time, List<List<Integer>> result, int[] visited) {
        visited[target] = 1;
        time[target] = lows[target] = timer++;

        for (int adj : adjacency.get(target)) {
            if (adj == parent) continue;

            if (visited[adj] != 1) {
                dfs(adjacency, adj, target, lows, time, result, visited);
                lows[target] = Math.min(lows[target], lows[adj]);

                if (lows[adj] > time[target]) {
                    result.add(Arrays.asList(target, adj));
                }
            } else {
                lows[target] = Math.min(lows[target], lows[adj]);
            }
        }
    }
}