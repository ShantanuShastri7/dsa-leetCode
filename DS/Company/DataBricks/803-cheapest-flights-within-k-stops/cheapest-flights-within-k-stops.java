class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjacency = new ArrayList<>();
        for(int i=0; i<n; i++) adjacency.add(new ArrayList<>());

        for(int i=0; i<flights.length; i++){
            adjacency.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, 999999);

        PriorityQueue<Pair<Integer, Pair<Integer,Integer>>> pq=new PriorityQueue<>(Comparator.comparingInt(a -> 
                                                                        a.getKey()));
        dist[src]=0;
        pq.offer(new Pair<>(0, new Pair<>(src, 0)));

        while(!pq.isEmpty()){
            Pair<Integer, Pair<Integer, Integer>> node = pq.poll();
            int hops = node.getKey();
            int source = node.getValue().getKey();
            int dis = node.getValue().getValue();

            if(hops>k) break;

            for(int[] adj : adjacency.get(source)){
                int next = adj[0];
                int nextDis = adj[1];

                if(dis+nextDis<dist[next] && hops<k+1){
                    dist[next] = dis+nextDis;
                    pq.offer(new Pair<>(hops+1, new Pair<>(next, dis+nextDis)));
                }
            }
        }

        return dist[dst]==999999?-1:dist[dst];
    }
}