class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> st = new Stack<>();

        List<int[]> h = new ArrayList<>();

        for(int i=0; i<position.length; i++){
            h.add(new int[]{position[i], speed[i]});
        }

        h.sort((a,b)->b[0]-a[0]);

        for(int i=0; i<position.length; i++){
            Double timeToFinish = (double) (target-h.get(i)[0])/h.get(i)[1];
            if(st.isEmpty() || st.peek()<timeToFinish){
                st.push(timeToFinish);
            }
        }

        return st.size();
    }
}