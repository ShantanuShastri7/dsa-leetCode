import java.util.*;

class Solution {
    // 1. Create our Result wrapper to bubble up the state
    class Result {
        long weight;
        List<Integer> path;

        public Result(long weight, List<Integer> path) {
            this.weight = weight;
            this.path = path;
        }
    }

    Result[][] memo;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        
        // 2. Map intervals to an int[][] to include their original index
        // arr[i] = [start, end, weight, original_index]
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i; 
        }

        // 3. Sort purely by Start Time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // DP table: n intervals, and up to 4 picks
        memo = new Result[n][5];

        // 4. Start the recursion
        Result res = solve(arr, 0, 4);

        // 5. Convert the result List into the required int[] array
        int[] ans = new int[res.path.size()];
        for (int i = 0; i < res.path.size(); i++) {
            ans[i] = res.path.get(i);
        }
        return ans;
    }

    private Result solve(int[][] arr, int index, int k) {
        // Base case: we are out of intervals or out of choices
        if (k == 0 || index >= arr.length) {
            return new Result(0, new ArrayList<>());
        }

        // Return cached result if available
        if (memo[index][k] != null) {
            return memo[index][k];
        }

        // CHOICE A: Skip this interval
        Result skip = solve(arr, index + 1, k);

        // CHOICE B: Take this interval
        int nextIndex = findNext(arr, index);
        Result takeNext = solve(arr, nextIndex, k - 1);
        
        long newWeight = takeNext.weight + arr[index][2];
        List<Integer> newPath = new ArrayList<>(takeNext.path);
        newPath.add(arr[index][3]); 
        
        // The problem requires lexicographical checking of the final chosen indices.
        // Because we process left-to-right, the original indices might be out of order.
        // We sort them so our tie-breaker logic compares them correctly. (Size is at most 4, so O(1) time).
        Collections.sort(newPath);

        Result take = new Result(newWeight, newPath);

        // Evaluate the winner
        Result best;
        if (take.weight > skip.weight) {
            best = take;
        } else if (skip.weight > take.weight) {
            best = skip;
        } else {
            // TIE-BREAKER: Weights are equal, compare lexicographically
            if (isLexicographicallySmaller(take.path, skip.path)) {
                best = take;
            } else {
                best = skip;
            }
        }

        // Cache and return
        memo[index][k] = best;
        return best;
    }

    // Binary search to find the next interval whose start time is STRICTLY GREATER than current end time
    private int findNext(int[][] arr, int index) {
        int low = index + 1;
        int high = arr.length - 1;
        int nextValid = arr.length; // Default to out of bounds
        int currentEnd = arr[index][1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid][0] > currentEnd) {
                nextValid = mid;
                high = mid - 1; // Try to find an even earlier valid start
            } else {
                low = mid + 1;
            }
        }
        return nextValid;
    }

    // Lexicographical array comparison helper
    private boolean isLexicographicallySmaller(List<Integer> a, List<Integer> b) {
        int minLength = Math.min(a.size(), b.size());
        for (int i = 0; i < minLength; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        // If all elements match up to the length of the shorter list, the shorter list is smaller
        return a.size() < b.size();
    }
}