class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int res=0;
        int currFloor=0;

        for(int i: requests){
            res+=Math.abs(i-currFloor);
            currFloor=i;
        }

        return res;
    }
}