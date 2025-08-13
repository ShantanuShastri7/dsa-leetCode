class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] visited = new int[graph.length];

        for(int i=0; i<graph.length; i++){
            if(dfs(graph, i, visited)){
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int[][] graph, int targetNode, int[] visited){
        if(visited[targetNode]!=0){
            return visited[targetNode]==2;
        }
        visited[targetNode]=1;
        
        for(int adj : graph[targetNode]){
            if (!dfs(graph, adj, visited)) {
                return false;
            }
        }

        visited[targetNode]=2;
        return true;
    }
}