import java.util.BitSet;

public class UrlDeduplicator {

    // 1. Storage: A massive bit array
    // Java's BitSet is perfect for this.
    private BitSet bloomFilter;
    private int size;
    
    // 2. Hash Functions: You need multiple distinct hash functions
    // to reduce collisions.
    private int[] seeds = {3, 7, 11, 13, 31, 37, 61}; // Prime numbers work well as seeds

    public UrlDeduplicator(int expectedItems) {
        // TODO: Initialize BitSet size based on expectedItems 
        // to maintain a low false positive rate (e.g., 1% error rate requires ~10 bits per item)
        this.size = -(expectedItems*Math.log(.001))/Math.pow(Math.log(2), 2);
        this.bloomFilter = new BitSet(this.size);
    }

    public void add(String url) {
        for(int seed : seeds){
            int bitToSet = hash(url, seed);
            this.bloomFilter.set(bitToSet);
        }
    }

    public boolean mightContain(String url) {
        // TODO: Run the URL through the same hash functions.
        // If ALL bits are true, return true.
        // If ANY bit is false, return false (Definite No).
        for(int seed : seeds){
            int bitToCheck = hash(url, seed);
            if(!this.bloomFilter.get(bitToCheck)) return false;
        }
        return true;
    }
    
    // Helper hash function
    private int hash(String url, int seed) {
        int result = 0;
        for (int i = 0; i < url.length(); i++) {
            result = result * seed + url.charAt(i);
        }
        // Ensure positive index and fit within bounds
        return Math.abs(result % size);
    }
}