class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Comparator<int[]> comp = Comparator
                .comparingDouble(a -> 1.0 / (((a[0] + 1.0) / (a[1] + 1.0)) - (a[0] * 1.0 / a[1])));

        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);

        for (int i = 0; i < classes.length; i++) {
            pq.offer(classes[i]);
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] best = pq.poll();
            best[0] += 1;
            best[1] += 1;
            pq.offer(best);
        }
        double ratio = 0;

        while (!pq.isEmpty()) {
            int[] clas = pq.poll();
            ratio += (double) clas[0] / clas[1];
        }

        return (double) ratio / classes.length;
    }
}