import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) {
        // 1. Build the adjacency list: graph[u] = List of int[]{v, time}
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        
        // 2. Initialize Priority Queue storing arrays of {time, power, node}
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]); // Primary: Ascending by time
            }
            return Long.compare(b[1], a[1]);     // Secondary: Descending by power
        });
        
        pq.offer(new long[]{0, power, source});
        
        // State tracking: max power we've had when popping a node
        long[] maxPowerSeen = new long[n];
        Arrays.fill(maxPowerSeen, -1);
        
        // 3. Process the Queue
        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long currTime = current[0];
            long currPower = current[1];
            int u = (int) current[2];
            
            // Target reached
            if (u == target) {
                return new long[]{currTime, currPower};
            }
            
            // Golden Rule Pruning
            if (currPower <= maxPowerSeen[u]) {
                continue;
            }
            maxPowerSeen[u] = currPower;
            
            // Cannot afford to leave this node
            if (currPower < cost[u]) {
                continue;
            }
            
            long nextPower = currPower - cost[u];
            
            // 4. Explore Neighbors
            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                long travelTime = neighbor[1];
                
                // Only push if it has the potential to beat the known best power state for 'v'
                if (nextPower > maxPowerSeen[v]) {
                    pq.offer(new long[]{currTime + travelTime, nextPower, v});
                }
            }
        }
        
        // 5. Failure State
        return new long[]{-1, -1};
    }
}