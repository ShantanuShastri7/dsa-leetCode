import java.util.*;

class Solution {
    class Job {
        int start, end, profit;
        Job(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.profit = p;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        // Step 1: Create Job objects and sort by start time
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> a.start - b.start);

        // Step 2: Memoization array
        Integer[] memo = new Integer[n];

        // Step 3: Recursive function with memoization
        return dfs(0, jobs, memo);
    }

    // Recursive function to return max profit starting from index 'i'
    private int dfs(int i, Job[] jobs, Integer[] memo) {
        if (i >= jobs.length) return 0; // Base case: no more jobs
        if (memo[i] != null) return memo[i]; // Already computed

        // Option 1: Skip current job
        int skip = dfs(i + 1, jobs, memo);

        // Option 2: Include current job
        int nextIndex = findNextJob(jobs, jobs[i].end);
        int include = jobs[i].profit + dfs(nextIndex, jobs, memo);

        // Take the max of including or skipping
        memo[i] = Math.max(skip, include);
        return memo[i];
    }

    // Binary search to find the next non-conflicting job
    private int findNextJob(Job[] jobs, int currentEnd) {
        int low = 0, high = jobs.length - 1;
        int ans = jobs.length; // default: no compatible job
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid].start >= currentEnd) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
