class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length);

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(ds.find(u)==ds.find(v)) return edges[i];
            else{
                ds.unionByRank(u,v);
            }
        }
        return new int[1];
    }

    class DisjointSet {
        public int[] parent;
        private int[] rank; 

        public DisjointSet(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i; 
                rank[i] = 0; 
            }
        }


        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]); 
            }
            return parent[node];
        }

        public void unionByRank(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV)
                return; 

            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootV] < rank[rootU]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}