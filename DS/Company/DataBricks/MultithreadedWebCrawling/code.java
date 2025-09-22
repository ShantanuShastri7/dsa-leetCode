import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        // Extract hostname from startUrl
        String hostName = getHostName(startUrl);

        // Thread-safe set to track visited URLs
        Set<String> visited = ConcurrentHashMap.newKeySet();
        visited.add(startUrl);

        // Thread pool for parallel crawling
        int numThreads = 8; // Can be tuned
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Count active tasks
        AtomicInteger taskCount = new AtomicInteger(1); // Start with 1 task for startUrl

        // Result list
        List<String> result = Collections.synchronizedList(new ArrayList<>());
        result.add(startUrl);

        // Submit the first task
        executor.submit(() -> crawlUrl(startUrl, htmlParser, hostName, visited, executor, taskCount, result));

        // Wait for all tasks to finish
        while (taskCount.get() > 0) {
            try {
                Thread.sleep(50); // small delay to avoid busy waiting
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        executor.shutdown();
        return result;
    }

    private void crawlUrl(String url, HtmlParser htmlParser, String hostName,
                          Set<String> visited, ExecutorService executor,
                          AtomicInteger taskCount, List<String> result) {
        try {
            List<String> urls = htmlParser.getUrls(url);

            for (String u : urls) {
                if (u.startsWith(hostName) && visited.add(u)) {
                    result.add(u);
                    taskCount.incrementAndGet();
                    executor.submit(() -> crawlUrl(u, htmlParser, hostName, visited, executor, taskCount, result));
                }
            }
        } finally {
            taskCount.decrementAndGet();
        }
    }

    private String getHostName(String url) {
        // Extract hostname like "http://example.com"
        int idx = url.indexOf('/', 7); // skip "http://" or "https://"
        if (idx != -1) return url.substring(0, idx);
        return url;
    }
}
