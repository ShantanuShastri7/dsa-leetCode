class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> dfs = new ArrayList<>();
        
        dfs(adj, 0, dfs, visited);
        
        return dfs;

    }
    
    private void dfs(ArrayList<ArrayList<Integer>> adj, Integer node, ArrayList<Integer> dfs, boolean[] visited){
        dfs.add(node);
        visited[node]=true;
        ArrayList<Integer> adjacents = adj.get(node);
        
        for(int adjacent: adjacents){
            if(!visited[adjacent]){
                dfs(adj, adjacent, dfs, visited);
            }
        }
        
        return;
    }
}
