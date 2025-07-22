class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            bfs.add(node);

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }

        return bfs;
    }
}
