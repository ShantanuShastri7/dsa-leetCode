class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        String[] start = startTime.split(":");        
        String[] end = endTime.split(":");

        return calculateSecs(end)-calculateSecs(start);
    }

    private int calculateSecs(String[] str){
        int time=0;

        time+=Integer.valueOf(str[2]);
        time+=Integer.valueOf(str[1])*60;
        time+=Integer.valueOf(str[0])*3600;

        return time;
    }
}