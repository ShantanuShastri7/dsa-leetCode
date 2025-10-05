class Solution {
    int m, n;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific border
        for (int i = 0; i < m; i++) dfs(heights, pacific, i, 0);
        for (int j = 0; j < n; j++) dfs(heights, pacific, 0, j);

        // Atlantic border
        for (int i = 0; i < m; i++) dfs(heights, atlantic, i, n - 1);
        for (int j = 0; j < n; j++) dfs(heights, atlantic, m - 1, j);

        // Collect cells that can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        for (int[] d : directions) {
            int newX = x + d[0];
            int newY = y + d[1];

            if (newX < 0 || newY < 0 || newX >= m || newY >= n || visited[newX][newY]) continue;
            if (heights[newX][newY] < heights[x][y]) continue;

            dfs(heights, visited, newX, newY);
        }
    }
}


//Was trying this approach on my own
// class Solution {
//     public List<List<Integer>> pacificAtlantic(int[][] heights) {
//         ArrayList<List<Integer>> result = new ArrayList<>();
//         boolean[][] visited = new boolean[heights.length][heights[0].length];
//         dfs(heights, visited, 0, 0, result);

//         return result;
//     }

//     private int dfs(int[][] heights, boolean[][] visited, int x, int y, ArrayList<List<Integer>> result){
//         if(x<=0 || y<=0) return 1;
//         if(x>=heights.length || y>=heights[0].length) return 0;

//         int[][] dxDy = {{-1,0}, {0,-1}, {1,0}, {0,1}};
//         boolean[] test = new boolean[3];

//         for(int[] dx : dxDy){
//             int newX = x+dx[0];
//             int newY = y+dx[1];
//             if(heights[newX][newY]<=heights[x][y] && !visited[newX][newY]){
//                 visited[newX][newY]=true;
//                 int res = dfs(heights, visited, newX, newY, result);
//                 if(res==-1) continue;
//                 test[res]=true;
//             }
//         }

//         if(test[0]&&test[1] || test[2]) {
//             result.add(new ArrayList<>(Arrays.asList(x, y)));
//             return 2;
//         } else if(test[0]){
//             return 0;
//         } else if(test[1]){
//             return 1;
//         }else {
//             return -1;
//         }
//     }
// }