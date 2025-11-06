class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        StringBuilder str = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[0][0] = true;
        helper(result, str, maze, 0,0, visited);
        Collections.sort(result); 
        return result;
    }
    
    private void helper(ArrayList<String> result, StringBuilder str, int[][] maze, int row, int column, boolean[][] visited){
        if(row==maze.length-1 && column==maze[0].length-1) {
            result.add(str.toString());
        }
        
        int[][] moves = new int[][] { {-1,0}, {1,0}, {0,-1}, {0,1} };
        
        for(int[] move : moves){
            int newRow = row+move[0];
            int newColumn = column+move[1];
            
            if(newRow>=0 && newRow<maze.length && newColumn>=0 && newColumn<maze[0].length && !visited[newRow][newColumn] &&maze[newRow][newColumn]==1){
                if(move[1]==0){
                    if(move[0]==-1) str.append("U");
                    else str.append("D");
                } else{
                    if(move[1]==-1) str.append("L");
                    else str.append("R");
                }
                visited[newRow][newColumn]=true;
                helper(result, str, maze, newRow, newColumn, visited);
                str.deleteCharAt(str.length()-1);
                visited[newRow][newColumn]=false;
            }
        }
    }
    
    
}
