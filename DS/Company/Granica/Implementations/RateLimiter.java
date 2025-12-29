public class RateLimiter {
    private final long capacity;
    private final double refillRatePerSecond;
    
    // State (Must be protected)
    private double currentTokens;
    private long lastRefillTimestamp;

    public TokenBucketRateLimiter(long capacity, double refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        
        // Start full
        this.currentTokens = capacity;
        this.lastRefillTimestamp = System.nanoTime();
    }

    // Returns true if request is allowed, false if rejected
    public synchronized boolean tryConsume() {
        refill();

        if (currentTokens >= 1) {
            currentTokens -= 1;
            return true; // Request Allowed
        }
        
        return false; // Request Throttled
    }

    // The "Lazy Refill" Logic
    private void refill() {
        long now = System.nanoTime();
        long timeSinceLastRefill = now - lastRefillTimestamp;

        // Convert nanoseconds to seconds for the rate calculation
        double secondsPassed = timeSinceLastRefill / 1_000_000_000.0;
        double tokensToAdd = secondsPassed * refillRatePerSecond;

        // Add tokens, but don't exceed capacity
        // We use Math.min to clamp it at the max capacity
        currentTokens = Math.min(capacity, currentTokens + tokensToAdd);
        
        // Update timestamp
        lastRefillTimestamp = now;
    }
}