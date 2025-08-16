// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        for(int k=0; k<dist.length; k++){
           for(int i=0; i<dist.length; i++){
                for(int j=0; j<dist.length; j++){
                    int firstLeg = dist[i][k];
                    int secondLeg = dist[k][j];
                    if(firstLeg==100000000 || secondLeg==100000000) continue;
                    else dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
    }
}
