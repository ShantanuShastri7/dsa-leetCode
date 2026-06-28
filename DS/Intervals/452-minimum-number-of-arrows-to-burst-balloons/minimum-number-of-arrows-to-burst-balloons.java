class Solution {
    public int findMinArrowShots(int[][] points) {
        ArrayList<Integer> arrowFiredIndex = new ArrayList<>();
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        arrowFiredIndex.add(points[0][1]);

        for(int i=0; i<points.length; i++){
            if(points[i][0]<=arrowFiredIndex.get(arrowFiredIndex.size()-1)){
                System.out.print("Catched with last arrow: "+points[i][0]+" "+points[i][1]+ "\n");
                continue;
            } else{
                arrowFiredIndex.add(points[i][1]);
            }
        }

        return arrowFiredIndex.size();
    }
}