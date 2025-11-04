class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            int k = edges[i][0];
            int n = edges[i][1];
            
            adj.get(k).add(n);
            adj.get(n).add(k);
        }
        
        int[] color = new int[v];
        
        return helper(adj, 0, color, m);
    }
    
    private boolean helper(ArrayList<ArrayList<Integer>> adj, int node, int[] colors, int m){
        if(node==adj.size()) return true;
        
        ArrayList<Integer> adjacent = adj.get(node);
        for(int color=1; color<=m; color++){
            if(isSafe(adj, node, color, colors)){
                colors[node]=color;
                if(helper(adj, node+1, colors, m)) return true;
                colors[node]=0;
            }
        }
        
        return false;
    }
    
    private boolean isSafe(ArrayList<ArrayList<Integer>> adj, int node, int color, int[] colors){
        ArrayList<Integer> adjacents = adj.get(node);
        
        for(Integer aj : adjacents){
            if(colors[aj]==color) return false;
        }
        
        return true;
    }
}
