// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[src]=0;
        
        for(int i=0; i<V; i++){
            for(int j=0; j<edges.length; j++){
                int source = edges[j][0];
                int target = edges[j][1];
                int cost = edges[j][2];
                
                if(distance[source]==Integer.MAX_VALUE) continue;
                
                if(distance[source]+cost<distance[target]){
                    distance[target]=distance[source]+cost;
                }
            }
        }
        
        for(int j=0; j<edges.length; j++){
            int source = edges[j][0];
            int target = edges[j][1];
            int cost = edges[j][2];
            
            if(distance[source]==Integer.MAX_VALUE) continue;
            
            if(distance[source]+cost<distance[target]){
               return new int[]{-1};
            }
        }
        
        for(int i=0; i<V; i++){
            if(distance[i]==Integer.MAX_VALUE) distance[i]=100000000;
        }
        
        return distance;
    }
}
