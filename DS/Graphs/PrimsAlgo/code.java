class Solution {
    public int spanningTree(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adjacency = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adjacency.add(new ArrayList<>());    
        }
        
        for(int i=0; i<edges.length; i++){
            adjacency.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
            adjacency.get(edges[i][1]).add(new int[]{edges[i][0], edges[i][2]});
        }
        
        boolean[] visited = new boolean[V];
        int sum=0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        pq.offer(new int[]{0,0});
        
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int target = node[1];
            int dist = node[0];
            
            if(visited[target]) continue;
            sum+=dist;
            visited[target]=true;
            
            for(int [] adj : adjacency.get(target)){
                int nextTarget = adj[0];
                int nextDistance = adj[1];
                
                if(!visited[nextTarget]){
                    pq.offer(new int[]{nextDistance, nextTarget});   
                }
            }
        }
        
        return sum;
    }
}
