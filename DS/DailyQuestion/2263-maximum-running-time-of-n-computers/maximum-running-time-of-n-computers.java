class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long totalEnergy = 0;
        for (int b : batteries) totalEnergy += b;

        long left = 0;
        long right = totalEnergy / n;   
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;  

            if (canRun(batteries, mid, n)) {
                result = mid;
                left = mid + 1;        
            } else {
                right = mid - 1;        
            }
        }

        return result;
    }

    private boolean canRun(int[] batteries, long currentTime, int n) {
        long sum = 0;

        for (int b : batteries) {
            sum += Math.min((long) b, currentTime);
        }

        return sum >= currentTime * n;
    }
}
