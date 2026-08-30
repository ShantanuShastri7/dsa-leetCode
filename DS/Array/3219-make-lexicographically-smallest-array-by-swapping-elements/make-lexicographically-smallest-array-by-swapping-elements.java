import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        if (n == 0) return new int[0];

        // 1. Pair each number with its original index
        int[][] paired = new int[n][2];
        for (int i = 0; i < n; i++) {
            paired[i][0] = nums[i];
            paired[i][1] = i; // Store original index
        }

        // 2. Sort the pairs based on the values
        Arrays.sort(paired, (a, b) -> Integer.compare(a[0], b[0]));

        // 3. Group them using the Transitive Property
        ArrayList<ArrayList<int[]>> groups = new ArrayList<>();
        
        // Start the first group with the first element
        groups.add(new ArrayList<>());
        groups.get(0).add(paired[0]);

        for (int i = 1; i < n; i++) {
            // If it's within the limit of the PREVIOUS sorted element, they share a group
            if (paired[i][0] - paired[i - 1][0] <= limit) {
                groups.get(groups.size() - 1).add(paired[i]);
            } else {
                // Otherwise, the limit is broken, start a brand new group
                ArrayList<int[]> newGroup = new ArrayList<>();
                newGroup.add(paired[i]);
                groups.add(newGroup);
            }
        }

        // 4. Reconstruct the final array group by group
        int[] res = new int[n];
        
        for (ArrayList<int[]> group : groups) {
            // Extract the original indices for this specific group
            ArrayList<Integer> indices = new ArrayList<>();
            for (int[] pair : group) {
                indices.add(pair[1]);
            }
            
            // Sort the indices so we fill the earliest available slots first
            Collections.sort(indices);
            
            // Map the sorted values directly into the sorted indices
            for (int i = 0; i < group.size(); i++) {
                int sortedIndex = indices.get(i);
                int sortedValue = group.get(i)[0];
                res[sortedIndex] = sortedValue;
            }
        }

        return res;
    }
}