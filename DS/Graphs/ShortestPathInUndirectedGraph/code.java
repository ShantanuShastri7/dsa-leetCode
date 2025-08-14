import java.util.*;

class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        Queue<Pair<Integer,Integer>> q = new ArrayDeque<>();
        int[] distance = new int[adj.size()];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        q.offer(new Pair<>(src, 0));
        distance[src] = 0;
        
        while(!q.isEmpty()){
            Pair<Integer,Integer> nodeDistance = q.poll();
            int node = nodeDistance.getFirst();
            int dist = nodeDistance.getSecond();
            
            for(int adjacent : adj.get(node)){
                if(dist + 1 < distance[adjacent]){
                    distance[adjacent] = dist + 1;
                    q.offer(new Pair<>(adjacent, dist + 1));
                }
            }
        }
        for(int i=0; i<adj.size(); i++){
            if(distance[i]==Integer.MAX_VALUE) distance[i]=-1;
        }
        return distance;
    }
}

class Pair<K, V> {
    private K first;
    private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
