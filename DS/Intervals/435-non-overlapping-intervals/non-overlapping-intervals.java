class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[1]-b[1]);

        int lastEnd=Integer.MIN_VALUE;
        int deleteCount=0;

        for(int i=0; i<intervals.length; i++){
            if(intervals[i][0]>=lastEnd){
                lastEnd=intervals[i][1];
            }else{
                deleteCount++;
            }
        }

        return deleteCount;   
    }
}