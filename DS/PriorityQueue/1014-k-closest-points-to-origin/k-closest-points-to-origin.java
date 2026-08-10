class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<List<Double>> pq = new PriorityQueue<>((a,b) -> Double.compare(a.get(0), b.get(0)));

        for(int i=0; i<points.length; i++){
            double dist = Math.sqrt(Math.pow(points[i][0]-0, 2) + Math.pow(points[i][1]-0, 2));
    
            ArrayList<Double> q = new ArrayList<>(Arrays.asList(dist, (double)points[i][0], (double)points[i][1]));
            pq.offer(q);
        }
        int[][] res = new int[k][2];
        for(int i=0; i<k; i++){
            List<Double> ans = pq.poll();
            res[i][0] = ans.get(1).intValue();
            res[i][1] = ans.get(2).intValue();
        }

        return res;
    }
}