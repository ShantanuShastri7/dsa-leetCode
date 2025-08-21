import java.util.*;

class Solution {
    private int timer = 0;

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] tin = new int[V];     // discovery time
        int[] low = new int[V];     // lowest reachable time
        boolean[] visited = new boolean[V];
        boolean[] isAP = new boolean[V];  // mark articulation points

        Arrays.fill(tin, -1);
        Arrays.fill(low, -1);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj, tin, low, visited, isAP);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isAP[i]) result.add(i);
        }

        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }

    private void dfs(int u, int parent, ArrayList<ArrayList<Integer>> adj,
                     int[] tin, int[] low, boolean[] visited, boolean[] isAP) {
        visited[u] = true;
        tin[u] = low[u] = timer++;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == parent) continue;  // ignore edge to parent

            if (!visited[v]) {
                dfs(v, u, adj, tin, low, visited, isAP);
                low[u] = Math.min(low[u], low[v]);

                if (parent != -1 && low[v] >= tin[u]) {
                    isAP[u] = true;  // articulation condition
                }

                children++;
            } else {
                // back edge
                low[u] = Math.min(low[u], tin[v]);
            }
        }

        // root node articulation point check
        if (parent == -1 && children > 1) {
            isAP[u] = true;
        }
    }
}
