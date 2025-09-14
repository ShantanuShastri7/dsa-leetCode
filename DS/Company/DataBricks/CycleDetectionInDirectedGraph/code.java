class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<List<Integer>> adjacency = new ArrayList<>();

        for (int i = 0; i < V; i++) adjacency.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjacency.get(u).add(v);
        }

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (cycle(adjacency, visited, pathVisited, i)) return true;
            }
        }
        return false;
    }

    private boolean cycle(ArrayList<List<Integer>> adjacency, boolean[] visited, boolean[] pathVisited, int node) {
        visited[node] = true;
        pathVisited[node] = true;

        for (Integer neighbor : adjacency.get(node)) {

            if (!visited[neighbor]) {
                if (cycle(adjacency, visited, pathVisited, neighbor)) return true;
            }
            
            else if (pathVisited[neighbor]) {
                return true;
            }
        }

        pathVisited[node] = false;
        return false;
    }
}
