class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);

        int[] res = new int[queries.length];
        
        Map<Integer, Integer> activeServers = new HashMap<>();
        
        int left = 0;
        int right = 0;

        for (int i = 0; i < sortedQueries.length; i++) {
            int currentQueryTime = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];
            
            int start = currentQueryTime - x;
            int end = currentQueryTime;

            while (right < logs.length && logs[right][1] <= end) {
                int serverId = logs[right][0];
                activeServers.put(serverId, activeServers.getOrDefault(serverId, 0) + 1);
                right++;
            }

            while (left < logs.length && logs[left][1] < start) {
                int serverId = logs[left][0];
                activeServers.put(serverId, activeServers.get(serverId) - 1);
                if (activeServers.get(serverId) == 0) {
                    activeServers.remove(serverId);
                }
                left++;
            }

            // The number of servers WITHOUT requests is total servers (n) minus ACTIVE servers
            res[originalIndex] = n - activeServers.size();
        }

        return res;
    }
}