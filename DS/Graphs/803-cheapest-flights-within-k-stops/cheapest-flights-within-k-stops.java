class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjacency = new ArrayList<>();
        for(int i=0; i<n; i++) adjacency.add(new ArrayList<>());
        int[] costAtNode = new int[n];
        Arrays.fill(costAtNode, Integer.MAX_VALUE);

        for(int i=0; i<flights.length; i++){
            adjacency.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }

        Queue<int[]> pq = new ArrayDeque<>();
        pq.offer(new int[]{src, 0, 0});
        costAtNode[src]=0;

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int target=node[0];
            int cost=node[1];
            int stop=node[2];

            if(stop>k) continue;

            for(int[] adj : adjacency.get(target)){
                if(cost+adj[1]<costAtNode[adj[0]] && stop<=k){
                    costAtNode[adj[0]]=cost+adj[1];
                    pq.offer(new int[]{adj[0], cost+adj[1], stop+1});
                }
            }
        }
        if(costAtNode[dst]==Integer.MAX_VALUE) return -1;
        return costAtNode[dst];
    }
}