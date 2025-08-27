class Solution {
    public int findPages(int[] arr, int m) {
        int n=arr.length;
        if (m > n) return -1;

        int low = Arrays.stream(arr).max().getAsInt(); 
        int high = Arrays.stream(arr).sum(); 
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isFeasible(arr, n, m, mid)) {
                result = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;  
            }
        }
        return result;
    }

    private static boolean isFeasible(int[] arr, int n, int m, int maxPages) {
        int students = 1, sum = 0;

        for (int pages : arr) {
            if (sum + pages > maxPages) {
                students++;
                sum = pages;
                if (students > m) return false;
            } else {
                sum += pages;
            }
        }
        return true;
    }
}
