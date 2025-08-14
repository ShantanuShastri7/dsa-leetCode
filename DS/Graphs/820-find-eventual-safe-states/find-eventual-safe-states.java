class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        int[] inorder = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            adjRev.add(new ArrayList<>());
        }   

        for(int i=0; i<graph.length; i++){
            for(int j : graph[i]){
                adjRev.get(j).add(i);
                inorder[i]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i<adjRev.size(); i++){
            if(inorder[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);
            for(int i : adjRev.get(node)){
                --inorder[i];
                if(inorder[i]==0) q.offer(i);
            }
        }
        Collections.sort(result);
        return result;
    }

    // public List<Integer> eventualSafeNodes(int[][] graph) {
    //     ArrayList<Integer> result = new ArrayList<>();
    //     int[] visited = new int[graph.length];

    //     for(int i=0; i<graph.length; i++){
    //         if(dfs(graph, i, visited)){
    //             result.add(i);
    //         }
    //     }
    //     return result;
    // }

    // private boolean dfs(int[][] graph, int targetNode, int[] visited){
    //     if(visited[targetNode]!=0){
    //         return visited[targetNode]==2;
    //     }
    //     visited[targetNode]=1;

    //     for(int adj : graph[targetNode]){
    //         if (!dfs(graph, adj, visited)) {
    //             return false;
    //         }
    //     }

    //     visited[targetNode]=2;
    //     return true;
    // }
}