public class RollingHashDedupe {

    private static final int WINDOW_SIZE = 48;
    private static final int TARGET_CHUNK_SIZE = 4096;
    
    private static final long MODULUS = 1L << 31; // Use a large prime or power of 2
    private static final int BASE = 31;     // Multiplier (Prime)

    public static void main(String[] args) throws IOException {
        // Simulate a file stream
        String dummyData = "This is a stream of data that will be chunked based on content...";
        InputStream stream = new ByteArrayInputStream(dummyData.getBytes());

        List<Integer> cutPoints = findChunkBoundaries(stream);
        
        System.out.println("Found " + cutPoints.size() + " chunks at indices: " + cutPoints);
    }

    /**
     * The Main Driver
     */
    public static List<Integer> findChunkBoundaries(InputStream inputStream) throws IOException {
        List<Integer> cutPoints = new ArrayList<>();
        BufferedInputStream bis = new BufferedInputStream(inputStream);

        // 1. Initialize the Window Buffer (Circular Buffer)
        byte[] window = new byte[WINDOW_SIZE];
        int windowIndex = 0;
        
        // 2. Pre-compute the "High Power" (Base^(WindowSize-1))
        // We need this to subtract the outgoing byte efficiently.
        long highPower = 1;
        for (int i = 0; i < WINDOW_SIZE - 1; i++) {
            highPower = (highPower * BASE) % MODULUS;
        }

        long currentHash = 0;
        int globalIndex = 0;
        int lastCut = 0;
        int b;

        // 3. The Stream Loop
        while ((b = bis.read()) != -1) {
            byte enteringByte = (byte) b;
            byte leavingByte = window[windowIndex];

            // A. Update the Window Buffer
            window[windowIndex] = enteringByte;
            windowIndex = (windowIndex + 1) % WINDOW_SIZE;

            // B. ROLLING HASH MATH (The Critical Part)
            // Step 1: Remove leading byte
            // (Note: Add MODULUS to ensure result is positive in Java)
            currentHash = (currentHash - (leavingByte * highPower) % MODULUS + MODULUS) % MODULUS;
            
            // Step 2: Shift Left
            currentHash = (currentHash * BASE) % MODULUS;
            
            // Step 3: Add new byte
            currentHash = (currentHash + enteringByte) % MODULUS;

            globalIndex++;

            // C. The Trigger (Content Defined Chunking)
            // We cut if the hash matches a specific pattern (e.g., lower 12 bits are 0)
            if (currentHash % TARGET_CHUNK_SIZE == 0 && globalIndex - lastCut >= WINDOW_SIZE) {
                System.out.println("CUT at index: " + globalIndex + " (Hash: " + currentHash + ")");
                cutPoints.add(globalIndex);
                lastCut = globalIndex;
                
                // Optional: Reset hash/window? 
                // Usually NO for pure CDC, but depends on implementation.
            }
        }
        
        // Add final chunk
        if (lastCut < globalIndex) {
            cutPoints.add(globalIndex);
        }

        return cutPoints;
    }
}