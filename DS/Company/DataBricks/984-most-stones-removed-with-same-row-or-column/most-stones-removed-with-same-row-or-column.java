class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxColumn = 0;
        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxColumn = Math.max(maxColumn, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxColumn + 2);
        int[] nodes = new int[maxRow + maxColumn + 2];

        for(int i=0; i<stones.length; i++){
            int x = stones[i][0];
            int y = maxRow+stones[i][1]+1;
            ds.unionByRank(x, y);
            nodes[x]=1;
            nodes[y]=1;
        }

        int count = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == 1 && ds.find(i) == i) {
                count++;
            }
        }

        return stones.length-count;
    }

    class DisjointSet{
        public int[] parent;
        public int[] rank;

        DisjointSet(int size){
            this.parent = new int[size];
            this.rank = new int[size];

            for(int i=0; i<size; i++){
                parent[i]=i;
                rank[i]=0;
            }
        }

        public void unionByRank(int u, int v){
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV) return;

            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootV] < rank[rootU]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }

        public int find(int u){
            if(parent[u]!=u){
                parent[u]=find(parent[u]);
            }

            return parent[u];
        }
    }
}