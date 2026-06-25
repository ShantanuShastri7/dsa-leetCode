class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        int[] inCount = new int[numCourses];

        for(int[] preReq : prerequisites){
            int main = preReq[0];
            int dependent = preReq[1];
            inCount[main]++;
            map.get(dependent).add(main);
        }

        int count=0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<numCourses; i++){
            if(inCount[i]==0){
                System.out.print("Adding course: "+i);
                pq.offer(i);
            }
        }

        while(!pq.isEmpty()){
            Integer node = pq.poll();
            count++;
            List<Integer> adjacents = map.get(node);

            for(Integer adj : adjacents){
                inCount[adj]--;
                if(inCount[adj]==0){
                    pq.offer(adj);
                }
            }
        }

        return count==numCourses;
    }
}