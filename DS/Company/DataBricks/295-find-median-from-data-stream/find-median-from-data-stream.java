import java.util.*;

class MedianFinder {
    // Max-heap for the lower half
    private PriorityQueue<Integer> maxHeap;
    // Min-heap for the upper half
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: Add to maxHeap
        maxHeap.offer(num);
        
        // Step 2: Balance - move max of maxHeap to minHeap
        minHeap.offer(maxHeap.poll());
        
        // Step 3: Rebalance if needed (maxHeap can have at most 1 more element)
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // Even number of elements
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // Odd number of elements
            return maxHeap.peek();
        }
    }
}