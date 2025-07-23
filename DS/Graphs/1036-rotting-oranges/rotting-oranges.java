class Solution {
    public int orangesRotting(int[][] grid) {
        int time=0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair<Pair<Integer,Integer>, Integer>> q = new ArrayDeque<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    q.offer(new Pair<>(new Pair<>(i, j), time));
                }
            }
        }

        while(!q.isEmpty()){
            Pair<Pair<Integer,Integer>, Integer> node = q.poll();
            int i = node.getKey().getKey();
            int j = node.getKey().getValue();
            int nodeTime = node.getValue();
            time=Math.max(time, nodeTime);

            if(i+1<n && grid[i+1][j]==1){
                q.offer(new Pair<>(new Pair<>(i+1, j), nodeTime+1));
                grid[i+1][j]=2;
            }
            if(i-1>=0 && grid[i-1][j]==1){
                q.offer(new Pair<>(new Pair<>(i-1, j), nodeTime+1));
                grid[i-1][j]=2;
            }
            if(j+1<m && grid[i][j+1]==1){
                q.offer(new Pair<>(new Pair<>(i, j+1), nodeTime+1));
                grid[i][j+1]=2;
            }
            if(j-1>=0 && grid[i][j-1]==1){
                q.offer(new Pair<>(new Pair<>(i, j-1), nodeTime+1));
                grid[i][j-1]=2;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time;
    }
}