import java.util.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Min-heap to track meeting end times
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // Step 2: Process each meeting
        for (int[] meeting : intervals) {
            // If the earliest meeting has ended, free up a room
            if (!heap.isEmpty() && heap.peek() <= meeting[0]) {
                heap.poll();
            }

            // Allocate a room for the current meeting
            heap.offer(meeting[1]);
        }

        // Size of heap = minimum rooms required
        return heap.size();
    }
}
