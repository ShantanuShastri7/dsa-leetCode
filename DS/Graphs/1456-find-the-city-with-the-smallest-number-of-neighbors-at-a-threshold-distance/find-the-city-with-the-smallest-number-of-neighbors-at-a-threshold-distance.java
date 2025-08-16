class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] fwMatrix = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(fwMatrix[i], 100000000);
            fwMatrix[i][i]=0;
        }

        for(int i=0; i<edges.length; i++){
            fwMatrix[edges[i][0]][edges[i][1]] = edges[i][2];
            fwMatrix[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        for(int k=0; k<fwMatrix.length; k++){
           for(int i=0; i<fwMatrix.length; i++){
                for(int j=0; j<fwMatrix.length; j++){
                    int firstLeg = fwMatrix[i][k];
                    int secondLeg = fwMatrix[k][j];
                    if(firstLeg==100000000 || secondLeg==100000000) continue;
                    else fwMatrix[i][j]=Math.min(fwMatrix[i][j], fwMatrix[i][k]+fwMatrix[k][j]);
                }
            }
        }
        int dist=Integer.MAX_VALUE;
        int count=1000000;
        int city=0;

        for(int i=0; i<n; i++){
            int cityCount=0;
            for(int j=0; j<n; j++){
                if(i==j) continue;
                else if(fwMatrix[i][j]<=distanceThreshold){
                    cityCount++;
                }
            }
            if(cityCount<count) {
                city = i;
                count=cityCount;
            }
            else if(cityCount==count) city = Math.max(city, i);
        }
        
        return city;
    }
}