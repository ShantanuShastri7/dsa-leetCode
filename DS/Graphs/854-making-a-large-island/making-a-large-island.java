class Solution {
    public int largestIsland(int[][] grid) {
        DisjointSet ds = new DisjointSet(grid.length * grid[0].length);
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        ds.unionBySize(grid[0].length * i + j, grid[0].length * (i - 1) + j);
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        ds.unionBySize(grid[0].length * i + j, grid[0].length * (i + 1) + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        ds.unionBySize(grid[0].length * i + j, grid[0].length * (i) + (j - 1));
                    }
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                        ds.unionBySize(grid[0].length * i + j, grid[0].length * (i) + (j + 1));
                    }
                }
            }
        }

        for (int i = 0; i < grid.length * grid[0].length; i++) {
            if (ds.find(i) == i)
                result = Math.max(result, ds.size[i]);
        }

        int newCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                newCount = 0;
                Set<Integer> done = new HashSet<>();
                if (grid[i][j] == 0) {
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        int parent = ds.find(grid[0].length * (i - 1) + j);
                        if (done.add(parent))
                            newCount += ds.size[parent];
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        int parent = ds.find(grid[0].length * (i + 1) + j);
                        if (done.add(parent))
                            newCount += ds.size[parent];
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        int parent = ds.find(grid[0].length * i + (j - 1));
                        if (done.add(parent))
                            newCount += ds.size[parent];
                    }
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                        int parent = ds.find(grid[0].length * i + (j + 1));
                        if (done.add(parent))
                            newCount += ds.size[parent];
                    }
                }
                newCount++;
                result = Math.max(result, newCount);
            }
        }

        return result;
    }

    class DisjointSet {
        public int[] parent;
        public int[] size; // Used for union by size

        public DisjointSet(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i; // Each node is its own parent
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