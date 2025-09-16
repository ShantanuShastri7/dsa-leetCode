class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        DisjointSet ds = new DisjointSet(accounts.size());

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    ds.unionByRank(map.get(email), i);
                }
            }
        }

        // Step 2: Collect emails by their root parent
        List<List<String>> emailsByParent = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            emailsByParent.add(new ArrayList<>());
        }

        for (String mail : map.keySet()) {
            int node = ds.find(map.get(mail));
            emailsByParent.get(node).add(mail);
        }

        // Step 3: Prepare final result
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            if (emailsByParent.get(i).size() == 0) continue;

            Collections.sort(emailsByParent.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // account name
            temp.addAll(emailsByParent.get(i));
            result.add(temp);
        }

        return result;
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