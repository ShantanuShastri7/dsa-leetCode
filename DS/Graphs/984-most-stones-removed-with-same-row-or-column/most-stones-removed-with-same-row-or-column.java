class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxColumn = 0;
        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxColumn = Math.max(maxColumn, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxColumn + 2);
        int[] map = new int[maxRow + maxColumn + 2];

        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0];
            int column = stones[i][1] + maxRow + 1; // shift columns

            ds.unionBySize(row, column);
            map[row] = 1;
            map[column] = 1;
        }

        int count = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1 && ds.find(i) == i) {
                count++;
            }
        }

        return stones.length - count;
    }

    class DisjointSet {
        public int[] parent;
        private int[] rank;
        private int[] size;

        public DisjointSet(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            size = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
                size[i] = 1; 
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

        public void unionBySize(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV) return;

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