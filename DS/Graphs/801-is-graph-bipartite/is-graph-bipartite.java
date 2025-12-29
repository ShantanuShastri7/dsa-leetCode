class Solution {
    public boolean isBipartite(int[][] graph) {
        int visited[] = new int[graph.length];
        Queue<ArrayList<Integer>> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {

        }

        //ArrayList<Integer> -> {color, node number}
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length >= 2 && visited[i]==0) {
                q.offer(new ArrayList<>(Arrays.asList(1, i)));

                while (!q.isEmpty()) {
                    ArrayList<Integer> curr = q.peek();
                    q.poll();
                    int node = curr.get(1);
                    int clr = curr.get(0);

                    if (visited[node] != 0) {
                        if (visited[node] != clr)
                            return false;
                    }
                    visited[node] = clr;

                    int newClr = clr == 1 ? 2 : 1;
                    for (int neigh : graph[node]) {
                        if (visited[neigh] == 0) {
                            q.offer(new ArrayList<>(Arrays.asList(newClr, neigh)));
                        } else {
                            if (visited[neigh] != newClr)
                                return false;
                        }

                    }
                }
            }
        }

        return true;
    }

    // public boolean isBipartite(int[][] graph) {
    //     int visited[] = new int[graph.length];

    //     for(int i=0; i<graph.length; i++){
    //         if(visited[i]==0){
    //             boolean result = dfs(graph, i, visited, 1);
    //             if(!result) return false;
    //         }
    //     }

    //     return true;
    // }

    private boolean dfs(int[][] graph, int node, int[] visited, int color) {
        if (visited[node] != 0) {
            return visited[node] == color;
        }
        visited[node] = color;
        int newColor = color == 1 ? 2 : 1;
        for (int adjacent : graph[node]) {
            boolean result = dfs(graph, adjacent, visited, newColor);
            if (!result)
                return false;
        }

        return true;
    }
}