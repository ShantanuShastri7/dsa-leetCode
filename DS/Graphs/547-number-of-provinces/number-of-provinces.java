class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int result = 0;
        boolean visited[] = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                result++;
                dfs(isConnected, visited, i);
            }
        }
        
        return result;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city){
        visited[city]=true;

        for(int j=0; j<isConnected.length; j++){
            if(!visited[j] && isConnected[city][j]==1){
                dfs(isConnected, visited, j);
            }
        }

        return;
    }
}