class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{return a[0]-b[0];});
        List<int[]> res = new ArrayList<>();

        int start=1;
        int[] elem = new int[]{intervals[0][0], intervals[0][1]};
        res.add(elem);

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]>elem[1]){
                int[] newElem = new int[]{intervals[i][0], intervals[i][1]};
                res.add(newElem);
                elem=newElem;
            }else{
                elem[0] = Math.min(elem[0], intervals[i][0]);
                elem[1] = Math.max(elem[1], intervals[i][1]);
            }
        }

        int[][] resa = new int[res.size()][2];

        for(int i=0; i<res.size(); i++){
            resa[i] = res.get(i);
        }

        return resa;
    }
}