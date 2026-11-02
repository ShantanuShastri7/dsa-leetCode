class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Build the adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        // minWt[node][consecutiveCount] tracks the minimum weight to reach this state
        int[][] minWt = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minWt[i], Integer.MAX_VALUE);
        }

        // PriorityQueue ordered by current weight: [weight, node, consecutiveCount]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // Start at node 0
        pq.offer(new int[]{0, 0, 1});
        minWt[0][1] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currWt = curr[0];
            int node = curr[1];
            int consCount = curr[2];

            // Because it's Dijkstra, the first time we pop the target node, it's the shortest path
            if (node == n - 1) {
                return currWt;
            }

            // If we found a shorter path to this state already, skip it
            if (currWt > minWt[node][consCount]) {
                continue;
            }

            char currChar = labels.charAt(node);

            for (int[] edge : adj.get(node)) {
                int nextNode = edge[0];
                int edgeWt = edge[1];
                char nextChar = labels.charAt(nextNode);

                int nextConsCount = (currChar == nextChar) ? consCount + 1 : 1;

                // Only proceed if we haven't exceeded 'k' consecutive identical characters
                if (nextConsCount <= k) {
                    int nextWt = currWt + edgeWt;
                    
                    // If this path is better than the previously recorded weight for this state
                    if (nextWt < minWt[nextNode][nextConsCount]) {
                        minWt[nextNode][nextConsCount] = nextWt;
                        pq.offer(new int[]{nextWt, nextNode, nextConsCount});
                    }
                }
            }
        }

        return -1; // No valid path found
    }
}