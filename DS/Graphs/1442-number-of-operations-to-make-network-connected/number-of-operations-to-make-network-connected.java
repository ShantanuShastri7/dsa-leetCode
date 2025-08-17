class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdges=0;
        int components=0;

        for(int i=0; i<connections.length; i++){
            if(ds.find(connections[i][0])==ds.find(connections[i][1])) extraEdges++;
            else{
                ds.unionBySize(connections[i][0], connections[i][1]);
            }
        }

        for(int i=0; i<n; i++){
            if(ds.parent[i]==i) components++;
        }

        if(extraEdges>=components-1) return components-1;

        return -1;
    }

    class DisjointSet {
        public int[] parent;
        private int[] rank; // Used for union by rank
        private int[] size; // Used for union by size

        public DisjointSet(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            size = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i; // Each node is its own parent
                rank[i] = 0; // Initially all ranks are 0
                size[i] = 1; // Initially size of each set is 1
            }
        }

        // Path compression find
        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]); // Path compression
            }
            return parent[node];
        }

        // Union by rank
        public void unionByRank(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV)
                return; // Already in same set

            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootV] < rank[rootU]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++; // Increase rank if equal
            }
        }

        // Union by size
        public void unionBySize(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV)
                return; // Already in same set

            if (size[rootU] < size[rootV]) {
                parent[rootU] = rootV;
                size[rootV] += size[rootU];
            } else {
                parent[rootV] = rootU;
                size[rootU] += size[rootV];
            }
        }
    }
}