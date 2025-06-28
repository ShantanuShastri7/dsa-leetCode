class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Min-heap to store top k elements (value, index)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1])
        );

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Extract top k elements and sort them by original index
        List<int[]> topK = new ArrayList<>(minHeap);
        topK.sort(Comparator.comparingInt(a -> a[1]));

        // Build result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i)[0];
        }

        return result;
    }
}
