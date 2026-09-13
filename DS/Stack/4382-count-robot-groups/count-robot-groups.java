class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n = position.length;
        // The stack will store arrays of double: {robot_index, time_of_death}
        Stack<double[]> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            double timeToMerge = Double.POSITIVE_INFINITY;
            
            while (!stack.isEmpty()) {
                double[] top = stack.peek();
                int j = (int) top[0];
                double jTime = top[1];
                
                double dist = position[j] - position[i];
                double t;
                
                if (dist <= distance) {
                    // Already within distance at t = 0
                    t = 0.0;
                } else if (speed[i] <= speed[j]) {
                    // i is slower than or equal to j, and initially further than distance.
                    // It will never catch j.
                    t = Double.POSITIVE_INFINITY;
                } else {
                    // Time it takes to close the gap to exactly `distance`
                    t = (dist - distance) / (double) (speed[i] - speed[j]);
                }
                
                if (t <= jTime) {
                    // i catches j before (or at the same time) j merges into something else.
                    // Therefore, i successfully merges into j's current group.
                    timeToMerge = t;
                    break;
                } else {
                    // j merges into the next group BEFORE i can catch j.
                    // j's group effectively teleports forward, so i must chase the next group directly.
                    stack.pop();
                }
            }
            
            // Push the current robot and the time it merges (dies as an independent group leader)
            stack.push(new double[]{i, timeToMerge});
        }
        
        // Count how many leaders never merge (timeToMerge is Infinity)
        int groupsRemaining = 0;
        for (double[] item : stack) {
            if (item[1] == Double.POSITIVE_INFINITY) {
                groupsRemaining++;
            }
        }
        
        return groupsRemaining;
    }
}