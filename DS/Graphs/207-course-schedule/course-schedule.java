class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> gg = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            gg.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            int m = prerequisites[i][0];
            int n = prerequisites[i][1];

            indegree[m]++;
            gg.get(n).add(m);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int res=0;
        while(!q.isEmpty()){
            int id = q.poll();
            res++;
            for(int linked : gg.get(id)){
                indegree[linked]--;
                if(indegree[linked]==0){
                    q.offer(linked);
                }
            }
        }

        return res==numCourses;
    }
}