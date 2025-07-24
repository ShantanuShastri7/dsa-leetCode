class Solution {
    
    public boolean isCycle(int n, int[][] edges) {
        int l = edges.length;
        boolean visited[] = new boolean[n];
        ArrayList<ArrayList<Integer>> adjacents = new ArrayList<>();

        for(int i=0; i<l; i++){
            adjacents.add(new ArrayList<>());
        }

        for(int i=0; i<l; i++){
            adjacents.get(edges[i][0]).add(edges[i][1]);
            adjacents.get(edges[i][1]).add(edges[i][0]);
        }

        for(int i=0; i<l; i++){
            if(!visited[i]){
                boolean result = dfsCycle(visited, -1, i, adjacents);
                if(result) return true;
            }
        }
        
        return false;
    }
    
    private boolean dfsCycle(boolean visited[], int parent, int target, ArrayList<ArrayList<Integer>> adjacents){
        visited[target]=true;
        
        for(int adjacent : adjacents.get(target)){
            if(!visited[adjacent]){
                boolean result = dfsCycle(visited, target, adjacent, adjacents);
                if(result) return true;
            } else if(adjacent!=parent) return true;
        }
        return false;
    }
}
