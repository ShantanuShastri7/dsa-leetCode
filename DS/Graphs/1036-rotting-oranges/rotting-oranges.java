class Solution {
    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxTime = 0;
        Queue<Pair<Integer, Pair<Integer, Integer>>> q = new LinkedList<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    visited[i][j] = true;
                    q.offer(new Pair<>(0, new Pair<>(i,j)));
                }
            }
        }
        int[][] dims = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while(!q.isEmpty()){
            Pair<Integer, Pair<Integer, Integer>> node = q.poll();
            int x = node.getValue().getKey();
            int y = node.getValue().getValue();
            int time = node.getKey();

            for(int[] dim : dims){
                int newX = x+dim[0];
                int newY = y+dim[1];

                if(newX>=0 && newX<grid.length && newY>=0 && newY<grid[0].length && !visited[newX][newY] && grid[newX][newY]==1){
                    visited[newX][newY] = true;
                    grid[newX][newY]=2;
                    maxTime = time+1;
                    q.offer(new Pair<>(time+1, new Pair<>(newX,newY)));
                }
            }
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        return maxTime;
    }

    private void bfs(int[][] grid, int x, int y, boolean[][] visited){
        Queue<Pair<Integer, Pair<Integer, Integer>>> q = new LinkedList<>();



    }
}
















// class Solution {
//     public int orangesRotting(int[][] grid) {
//         int time=0;
//         int n = grid.length;
//         int m = grid[0].length;
//         Queue<Pair<Pair<Integer,Integer>, Integer>> q = new ArrayDeque<>();

//         for(int i=0; i<grid.length; i++){
//             for(int j=0; j<grid[0].length; j++){
//                 if(grid[i][j]==2){
//                     q.offer(new Pair<>(new Pair<>(i, j), time));
//                 }
//             }
//         }

//         while(!q.isEmpty()){
//             Pair<Pair<Integer,Integer>, Integer> node = q.poll();
//             int i = node.getKey().getKey();
//             int j = node.getKey().getValue();
//             int nodeTime = node.getValue();
//             time=Math.max(time, nodeTime);

//             if(i+1<n && grid[i+1][j]==1){
//                 q.offer(new Pair<>(new Pair<>(i+1, j), nodeTime+1));
//                 grid[i+1][j]=2;
//             }
//             if(i-1>=0 && grid[i-1][j]==1){
//                 q.offer(new Pair<>(new Pair<>(i-1, j), nodeTime+1));
//                 grid[i-1][j]=2;
//             }
//             if(j+1<m && grid[i][j+1]==1){
//                 q.offer(new Pair<>(new Pair<>(i, j+1), nodeTime+1));
//                 grid[i][j+1]=2;
//             }
//             if(j-1>=0 && grid[i][j-1]==1){
//                 q.offer(new Pair<>(new Pair<>(i, j-1), nodeTime+1));
//                 grid[i][j-1]=2;
//             }
//         }

//         for(int i=0; i<n; i++){
//             for(int j=0; j<m; j++){
//                 if(grid[i][j]==1){
//                     return -1;
//                 }
//             }
//         }
//         return time;
//     }
// }