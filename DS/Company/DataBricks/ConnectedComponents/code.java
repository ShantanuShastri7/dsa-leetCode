class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<List<Integer>> adjacency = new ArrayList<>();
        
        for(int i=0; i<V; i++) adjacency.add(new ArrayList<>());
        
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adjacency.get(u).add(v);
            adjacency.get(v).add(u);
        }
        
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                ArrayList<Integer> res = bfs(adjacency, i, visited);
                result.add(res);
            }
        }
        
        return result;
    }
    
    private ArrayList<Integer> bfs(ArrayList<List<Integer>> adjacency, Integer node, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        q.offer(node);
        visited[node] = true;
        
        while(!q.isEmpty()){
            Integer start = q.poll();
            result.add(start);
            
            for(int adj : adjacency.get(start)){
                if(!visited[adj]) {
                    q.offer(adj);
                    visited[adj] = true;
                }
            }
        }
        
        return result;
    }
}
