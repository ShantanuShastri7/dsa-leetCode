class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // Track the total requests handled by each server
        int[] count = new int[k];
        
        // TreeSet keeps available server IDs strictly sorted: 0, 1, 2, ..., k-1
        TreeSet<Integer> freeServers = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            freeServers.add(i);
        }
        
        // Min-heap stores busy servers as [endTime, serverId] sorted by endTime
        PriorityQueue<int[]> busyQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < arrival.length; i++) {
            int startTime = arrival[i];
            
            // 1. Free up all servers whose tasks finished at or before the current arrival time
            while (!busyQueue.isEmpty() && busyQueue.peek()[0] <= startTime) {
                int[] finished = busyQueue.poll();
                freeServers.add(finished[1]);
            }
            
            // If no servers are available, drop the request
            if (freeServers.isEmpty()) {
                continue;
            }
            
            // 2. Find the next available server starting from (i % k)
            Integer targetServer = freeServers.ceiling(i % k);
            
            // 3. Wrap-around logic: If no server found >= (i % k), pick the absolute lowest available ID
            if (targetServer == null) {
                targetServer = freeServers.first();
            }
            
            // 4. Assign the task to the selected server
            count[targetServer]++;
            freeServers.remove(targetServer);
            busyQueue.offer(new int[]{startTime + load[i], targetServer});
        }
        
        // 5. Gather all servers that processed the maximum number of requests
        int maxRequests = 0;
        for (int c : count) {
            maxRequests = Math.max(maxRequests, c);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }
        
        return result;
    }
}