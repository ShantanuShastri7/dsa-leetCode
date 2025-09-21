import java.util.LinkedList;
import java.util.Queue;

class HitCounter {
    private Queue<Integer> hits;

    public HitCounter() {
        hits = new LinkedList<>();
    }

    // Record a hit
    public void hit(int timestamp) {
        hits.offer(timestamp);
    }

    // Return hits in last 5 minutes
    public int getHits(int timestamp) {
        // Remove hits older than 300 seconds
        while (!hits.isEmpty() && hits.peek() <= timestamp - 300) {
            hits.poll();
        }
        return hits.size();
    }
}
