class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        int[] result = new int[numCourses];


        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            int u = pre[1], v = pre[0];
            adj.get(u).add(v);   
            inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0)
                q.offer(i);

        int count = 0;

        while (!q.isEmpty()) {
            int course = q.poll();
            count++;
            result[count-1]=course;

            for (int next : adj.get(course)) {
                --inDegree[next];
                if (inDegree[next] == 0)
                    q.offer(next);
            }
        }

        return numCourses!=count?new int[0]:result;
    }
}