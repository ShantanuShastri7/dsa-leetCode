class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacency = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<prerequisites.length; i++){
            adjacency.computeIfAbsent(prerequisites[i][1], k -> new ArrayList<>()).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0) st.push(i);
        }

        int topo = 0;

        while(!st.isEmpty()){
            int node = st.pop();
            topo++;
            List<Integer> adj = adjacency.getOrDefault(node, new ArrayList<>());

            for(int i=0; i<adj.size(); i++){
                indegree[adj.get(i)] = indegree[adj.get(i)]-1;

                if(indegree[adj.get(i)]==0) {
                    st.push(adj.get(i));
                }
            }
        }

        return topo==numCourses?true:false;
    }
}