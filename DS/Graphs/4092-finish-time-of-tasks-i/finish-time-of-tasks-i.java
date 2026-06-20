class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int parent = edges[i][0];
            int child = edges[i][1];

            map.get(parent).add(child);
        }

        return dfsHelper(map, baseTime, 0);

    }

    private long dfsHelper(Map<Integer, ArrayList<Integer>> map, int[] baseTime, int index){
        if(map.get(index).size()==0) return (long) baseTime[index];

        long maxTime = Long.MIN_VALUE;
        long minTime = Long.MAX_VALUE;

        for(int i=0; i<map.get(index).size(); i++){
            int indexToCheck = map.get(index).get(i);
            long data = dfsHelper(map, baseTime, indexToCheck);

            maxTime = Math.max(maxTime, data);
            minTime = Math.min(minTime, data);
        }

        return (maxTime - minTime) + (long) baseTime[index] + maxTime;
    }
}