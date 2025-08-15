class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        int[] result = new int[V];
        int[] parent = new int[V];
        for(int i=0; i<V; i++){
            parent[i]=i;
        }
        Arrays.fill(result, Integer.MAX_VALUE);
        
        ArrayList<ArrayList<int[]>> adjacency = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjacency.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            adjacency.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
            adjacency.get(edges[i][1]).add(new int[]{edges[i][0], edges[i][2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        result[src]=0;
        for(int[] adj : adjacency.get(src)){
            result[adj[0]]=adj[1];
            pq.offer(new int[]{adj[1], adj[0]});
        }
        
        while(!pq.isEmpty()){
            int[] neighbour = pq.poll();
            int node = neighbour[1];
            int dist = neighbour[0];
            
            for(int[] adj : adjacency.get(node)){
                if(dist+adj[1]<result[adj[0]]){
                    result[adj[0]] = dist+adj[1];
                    pq.offer(new int[]{dist+adj[1], adj[0]});
                }
            }
        }
        
        return result;
    }
}
