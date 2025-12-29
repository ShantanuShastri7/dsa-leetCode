public class StreamDuplicateFinder {

    private static final int BIT_SET_SIZE = 2_147_483_647; // Max Integer
    private final BitSet bloomFilter;
    
    // Multiple seeds to create independent hash functions
    private final int[] seeds = {3, 7, 11, 13, 31, 37, 61};

    public StreamDuplicateFinder() {
        this.bloomFilter = new BitSet(BIT_SET_SIZE);
    }

    public void findDuplicates(InputStream inputStream) {
        // Use BufferedReader for efficient IO reading
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                if (mightContain(line)) {
                    // It is LIKELY a duplicate. 
                    // In a probabilistic solution, we print it.
                    System.out.println("Duplicate Found: " + line);
                } else {
                    // It is definitely new. Add to filter.
                    add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // --- Bloom Filter Logic ---

    private void add(String s) {
        for (int seed : seeds) {
            int hash = hash(s, seed);
            bloomFilter.set(hash);
        }
    }

    private boolean mightContain(String s) {
        for (int seed : seeds) {
            int hash = hash(s, seed);
            if (!bloomFilter.get(hash)) {
                return false; // Definitely not present
            }
        }
        return true; // Probably present
    }

    // Standard string hashing algorithm adapted for different seeds
    private int hash(String s, int seed) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * seed + s.charAt(i);
        }
        // Force positive index and modulo by size
        return (result & 0x7fffffff) % BIT_SET_SIZE;
    }

    // --- Main Driver ---
    public static void main(String[] args) throws IOException {
        StreamDuplicateFinder finder = new StreamDuplicateFinder();
        
        // Simulating a stream via FileInputStream
        // In interview: finder.findDuplicates(new FileInputStream("massive_log.txt"));
        
        // Simulation for compilation:
        String dummyData = "google.com\nyahoo.com\ngoogle.com\nfacebook.com";
        finder.findDuplicates(new java.io.ByteArrayInputStream(dummyData.getBytes()));
    }
}