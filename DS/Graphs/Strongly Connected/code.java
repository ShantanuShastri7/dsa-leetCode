import java.util.*;

class Solution {
    // Function to find number of strongly connected components
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Step 1: Order nodes by finish time
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(i, adj, visited, stack);
            }
        }

        // Step 2: Transpose graph
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            transpose.add(new ArrayList<>());
        }
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                transpose.get(v).add(u);
            }
        }

        // Step 3: DFS on transpose in order of stack
        Arrays.fill(visited, false);
        int sccCount = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                dfs2(node, transpose, visited);
                sccCount++;
            }
        }

        return sccCount;
    }

    private void dfs1(int u, ArrayList<ArrayList<Integer>> adj,
                      boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs1(v, adj, visited, stack);
            }
        }
        stack.push(u); // push when finished
    }

    private void dfs2(int u, ArrayList<ArrayList<Integer>> transpose, boolean[] visited) {
        visited[u] = true;
        for (int v : transpose.get(u)) {
            if (!visited[v]) {
                dfs2(v, transpose, visited);
            }
        }
    }
}
