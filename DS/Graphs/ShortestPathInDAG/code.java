import java.util.*;

class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);

        boolean[] visited = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();

        // Adjacency list with weights
        ArrayList<ArrayList<Pair<Integer, Integer>>> adjacency = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjacency.add(new ArrayList<>());
        }

        // Build graph
        for (int i = 0; i < E; i++) {
            int src = edges[i][0];
            int target = edges[i][1];
            int weight = edges[i][2];
            adjacency.get(src).add(new Pair<>(target, weight));
        }

        // Topological sort
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adjacency, i, stack, visited);
            }
        }

        // Set source node
        int source = 0; 
        result[source] = 0;

        // Relax edges in topological order
        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (result[node] != Integer.MAX_VALUE) {
                for (Pair<Integer, Integer> adj : adjacency.get(node)) {
                    if (result[node] + adj.getSecond() < result[adj.getFirst()]) {
                        result[adj.getFirst()] = result[node] + adj.getSecond();
                    }
                }
            }
        }
        for(int i=0; i<V; i++){
            if(result[i]==Integer.MAX_VALUE) result[i]=-1;
        }
        return result;
    }

    private void dfs(ArrayList<ArrayList<Pair<Integer, Integer>>> adjacency, int src, Deque<Integer> stack, boolean[] visited) {
        visited[src] = true;
        for (Pair<Integer, Integer> adj : adjacency.get(src)) {
            if (!visited[adj.getFirst()]) {
                dfs(adjacency, adj.getFirst(), stack, visited);
            }
        }
        stack.push(src);
    }
}

class Pair<K, V> {
    private K first;
    private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
