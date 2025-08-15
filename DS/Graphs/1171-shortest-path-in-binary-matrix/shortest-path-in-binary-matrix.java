class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1; 
        if(grid.length==1) return 1;
        int result = 99999;
        int[][] distance = new int[grid.length][grid.length];
        for(int i=0; i<grid.length; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,1});

        while(!q.isEmpty()){
            int[] details = q.poll();
            int i = details[0];
            int j = details[1];
            int dist = details[2];

            for(int a=-1; a<2; a++){
                int newi = i+a;
                for(int b=-1; b<2; b++){
                    int newj = j+b;

                    if(newi>=0 && newi<grid.length && newj>=0 && newj<grid.length && grid[newi][newj]==0){
                        if(dist+1<distance[newi][newj]){
                            distance[newi][newj]=dist+1;
                            q.offer(new int[]{newi, newj, dist+1});
                        }
                    }
                }
            }
        }

        return distance[grid.length-1][grid.length-1]==Integer.MAX_VALUE?-1:distance[grid.length-1][grid.length-1];
    }
}