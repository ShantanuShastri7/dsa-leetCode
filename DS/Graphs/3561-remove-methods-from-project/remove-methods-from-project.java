class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // 1. Build the Adjacency List
        List<List<Integer>> cords = new ArrayList<>();
        for(int i = 0; i < n; i++){
            cords.add(new ArrayList<>());
        }

        for(int i = 0; i < invocations.length; i++){
            int x = invocations[i][0];
            int y = invocations[i][1];
            cords.get(x).add(y);
        }

        // 2. Find all suspicious methods using DFS
        boolean[] suspicious = new boolean[n];
        suspicious[k] = true;
        dfs(cords, k, suspicious);

        // 3. Verify if we are allowed to remove the suspicious group
        boolean canRemove = true;
        for(int i = 0; i < invocations.length; i++){
            int u = invocations[i][0];
            int v = invocations[i][1];
            
            // If a NON-suspicious method calls a SUSPICIOUS method, we abort!
            if(!suspicious[u] && suspicious[v]){
                canRemove = false;
                break;
            }
        }

        // 4. Build the final result
        List<Integer> res = new ArrayList<>();
        if(canRemove){
            // Return only the non-suspicious methods
            for(int i = 0; i < n; i++){
                if(!suspicious[i]){
                    res.add(i);
                }
            }
        } else {
            // Return ALL methods (none are removed)
            for(int i = 0; i < n; i++){
                res.add(i);
            }
        }

        return res;
    }

    private void dfs(List<List<Integer>> cords, int node, boolean[] suspicious){
        List<Integer> neighbours = cords.get(node);

        for(int i = 0; i < neighbours.size(); i++){
            int next = neighbours.get(i);

            if(!suspicious[next]){
                suspicious[next] = true;
                dfs(cords, next, suspicious);
            }
        }
    }
}