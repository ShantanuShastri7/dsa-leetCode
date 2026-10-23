class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort cars by starting position descending (closest to target first)
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];

            // If the car behind takes MORE time than the fleet ahead,
            // it cannot catch up and forms a new fleet.
            if (st.isEmpty() || time > st.peek()) {
                st.push(time);
            }
            // Otherwise, it catches up to the fleet ahead and merges (we do nothing).
        }

        return st.size();
    }
}