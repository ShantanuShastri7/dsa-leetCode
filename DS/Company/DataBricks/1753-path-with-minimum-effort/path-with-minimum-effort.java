class Solution {
    public int minimumEffortPath(int[][] heights) {
        if(heights.length==1 && heights[0].length==1) return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        int[][] visited = new int[heights.length][heights[0].length];
        for(int i=0; i<heights.length; i++) Arrays.fill(visited[i], Integer.MAX_VALUE);

        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>(Comparator.comparingInt(a 
                                                                                        -> a.getKey()));
        pq.offer(new Pair<>(0, new Pair<>(0,0)));

        while(!pq.isEmpty()){
            Pair<Integer, Pair<Integer, Integer>> node = pq.poll();
            int effort = node.getKey();
            int x = node.getValue().getKey();
            int y = node.getValue().getValue();

            for(int[] dir : dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(newX>=0 && newX<heights.length && newY>=0 && newY<heights[0].length){
                    int currentHeightDiff = Math.abs(heights[x][y] - heights[newX][newY]);
                    int toCompare = Math.max(effort, currentHeightDiff);
                    if(toCompare < visited[newX][newY]){
                        visited[newX][newY] = toCompare;
                        pq.offer(new Pair<>(toCompare, new Pair<>(newX, newY)));
                    }
                }
            }
        }

        return visited[heights.length-1][heights[0].length-1];
    }
}