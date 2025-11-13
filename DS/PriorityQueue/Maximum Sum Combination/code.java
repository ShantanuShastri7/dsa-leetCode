class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((w, e) -> e[0] - w[0]);

        Set<String> visited = new HashSet<>();

        maxHeap.offer(new int[]{a[n - 1] + b[n - 1], n - 1, n - 1});
        visited.add((n - 1) + "," + (n - 1));

        ArrayList<Integer> result = new ArrayList<>();

        while (k-- > 0 && !maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            int sum = current[0], i = current[1], j = current[2];

            result.add(sum);

            if (i - 1 >= 0) {
                String key1 = (i - 1) + "," + j;
                if (!visited.contains(key1)) {
                    maxHeap.offer(new int[]{a[i - 1] + b[j], i - 1, j});
                    visited.add(key1);
                }
            }

            if (j - 1 >= 0) {
                String key2 = i + "," + (j - 1);
                if (!visited.contains(key2)) {
                    maxHeap.offer(new int[]{a[i] + b[j - 1], i, j - 1});
                    visited.add(key2);
                }
            }
        }

        return result;
    }
}
