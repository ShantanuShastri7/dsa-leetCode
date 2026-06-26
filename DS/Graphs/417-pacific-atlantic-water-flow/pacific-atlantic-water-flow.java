class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] visited = new int[heights.length][heights[0].length];
        boolean[][] isVisited = new boolean[heights.length][heights[0].length];
        boolean[][] isVisited2 = new boolean[heights.length][heights[0].length];
        
        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[0].length; j++){
                if(i==heights.length-1 || j==heights[0].length-1){
                    if(!isVisited[i][j]) dfs(heights, visited, i, j, isVisited);
                }
            }
        }

        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[0].length; j++){
                if(i==0 || j==0){
                     if(!isVisited2[i][j]) dfs(heights, visited, i, j, isVisited2);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[0].length; j++){
                if(visited[i][j]==2){
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int[][] visited, int x, int y, boolean[][] isVisited){
        visited[x][y]++;
        isVisited[x][y]=true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int maxX = heights.length; 
        int maxY = heights[0].length;

        for(int[] direct : directions){
            int newX = x+direct[0];
            int newY = y+direct[1];

            if(newX>=0 && newX<maxX && newY>=0 && newY<maxY && !isVisited[newX][newY] && heights[newX][newY]>=heights[x][y]){
                dfs(heights, visited, newX, newY, isVisited);
            }
        }

        return;
    }
}