class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->{return a[0]-b[0];});

        int[] n = new int[]{intervals[0][0], intervals[0][1]};
        ans.add(n);

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]<=n[1]){
                n[1]=Math.max(n[1], intervals[i][1]);
            }else{
                n = new int[]{intervals[i][0], intervals[i][1]};
                ans.add(n);
            }
        }

        int[][] res = new int[ans.size()][2];

        for(int i=0; i<ans.size(); i++){
            res[i][0]=ans.get(i)[0];
            res[i][1]=ans.get(i)[1];
        }

        return res;
    }
}