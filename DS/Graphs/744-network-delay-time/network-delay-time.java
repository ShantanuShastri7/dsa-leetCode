import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjacency = new ArrayList<>();
        for (int i = 0; i <= n; i++) adjacency.add(new ArrayList<>());

        for (int[] time : times) {
            adjacency.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int[] delayAtNode = new int[n + 1];
        Arrays.fill(delayAtNode, Integer.MAX_VALUE);
        delayAtNode[k] = 0;

        Queue<int[]> pq = new ArrayDeque<>();
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int timeSoFar = curr[1];

            if (timeSoFar > delayAtNode[node]) continue;

            for (int[] adj : adjacency.get(node)) {
                int nextNode = adj[0];
                int weight = adj[1];
                if (timeSoFar + weight < delayAtNode[nextNode]) {
                    delayAtNode[nextNode] = timeSoFar + weight;
                    pq.offer(new int[]{nextNode, delayAtNode[nextNode]});
                }
            }
        }

        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (delayAtNode[i] == Integer.MAX_VALUE) return -1;
            maxDelay = Math.max(maxDelay, delayAtNode[i]);
        }
        return maxDelay;
    }
}