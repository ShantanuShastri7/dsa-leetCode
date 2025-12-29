import java.io.*;
import java.util.*;

public class ExternalDeduplicator {

    // Adjust based on your available RAM. 
    // Example: 100,000 strings might take ~10-20MB RAM depending on string length.
    private static final int CHUNK_SIZE = 10000; 

    public static void main(String[] args) throws IOException {
        String inputObj = "huge_input.txt";
        String outputObj = "deduplicated_output.txt";
        
        // 1. Split and Sort Chunks
        List<File> tempFiles = splitAndSortChunks(inputObj);
        
        // 2. Merge and Deduplicate
        mergeChunks(tempFiles, outputObj);
    }

    private static List<File> splitAndSortChunks(String inputFile) throws IOException {
        List<File> tempFiles = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            List<String> chunk = new ArrayList<>();
            String line;
            
            while ((line = br.readLine()) != null) {
                chunk.add(line);
                
                if (chunk.size() == CHUNK_SIZE) {
                    tempFiles.add(saveSortedChunk(chunk));
                    chunk.clear();
                }
            }
            
            // Handle remaining lines
            if (!chunk.isEmpty()) {
                tempFiles.add(saveSortedChunk(chunk));
            }
        }
        return tempFiles;
    }

    private static File saveSortedChunk(List<String> chunk) throws IOException {
        Collections.sort(chunk); // Sort in memory
        File tempFile = File.createTempFile("chunk", ".txt");
        tempFile.deleteOnExit(); // Auto-cleanup on JVM exit
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            for (String line : chunk) {
                bw.write(line);
                bw.newLine();
            }
        }
        return tempFiles.isEmpty() ? tempFile : tempFile; // Return the file object
    }

    private static void mergeChunks(List<File> tempFiles, String outputFile) throws IOException {
        PriorityQueue<FileBuffer> pq = new PriorityQueue<>();
        
        // Open all temp files and add their first line to the PQ
        for (File f : tempFiles) {
            FileBuffer fb = new FileBuffer(f);
            if (!fb.isEmpty()) {
                pq.add(fb);
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String lastWritten = null;

            while (!pq.isEmpty()) {
                FileBuffer currentBuffer = pq.poll();
                String currentLine = currentBuffer.peek();

                // DEDUPLICATION LOGIC
                // Only write if it's different from the last written line
                if (lastWritten == null || !currentLine.equals(lastWritten)) {
                    bw.write(currentLine);
                    bw.newLine();
                    lastWritten = currentLine;
                }

                // Advance the file pointer for the buffer we just used
                currentBuffer.pop();
                
                // If the file still has lines, put it back in the PQ
                if (!currentBuffer.isEmpty()) {
                    pq.add(currentBuffer);
                } else {
                    currentBuffer.close(); // Close file reader when empty
                }
            }
        }
    }

    // Wrapper class to handle reading from temp files
    // Implements Comparable so PriorityQueue knows how to sort them
    static class FileBuffer implements Comparable<FileBuffer>, AutoCloseable {
        private BufferedReader reader;
        private String cache;

        public FileBuffer(File file) throws IOException {
            this.reader = new BufferedReader(new FileReader(file));
            reload();
        }

        private void reload() throws IOException {
            this.cache = this.reader.readLine();
        }

        public boolean isEmpty() {
            return this.cache == null;
        }

        public String peek() {
            return this.cache;
        }

        public void pop() throws IOException {
            reload();
        }
        
        @Override
        public void close() throws IOException {
            this.reader.close();
        }

        @Override
        public int compareTo(FileBuffer other) {
            return this.cache.compareTo(other.cache);
        }
    }
}