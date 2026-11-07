class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        // [weight, index] - Ordered by weight, then index
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        // [freeTime, weight, index] - Ordered by free time, then weight, then index
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        
        // Initially all servers are free
        for (int i = 0; i < servers.length; i++) {
            freeServers.offer(new int[]{servers[i], i});
        }
        
        int[] res = new int[tasks.length];
        int currentTime = 0;
        
        for (int i = 0; i < tasks.length; i++) {
            // Time cannot go backwards; it is at least the time the task arrived
            currentTime = Math.max(currentTime, i);
            
            // If no free servers are available right now, we must wait.
            // Fast-forward time to the moment the next busy server finishes.
            if (freeServers.isEmpty()) {
                currentTime = Math.max(currentTime, busyServers.peek()[0]);
            }
            
            // Move servers that have finished their tasks by `currentTime` back to freeServers
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime) {
                int[] server = busyServers.poll();
                freeServers.offer(new int[]{server[1], server[2]});
            }
            
            // Assign the current task to the best available free server
            int[] assignedServer = freeServers.poll();
            res[i] = assignedServer[1];
            
            // Send the server to work (mark it busy)
            busyServers.offer(new int[]{currentTime + tasks[i], assignedServer[0], assignedServer[1]});
        }
        
        return res;
    }
}