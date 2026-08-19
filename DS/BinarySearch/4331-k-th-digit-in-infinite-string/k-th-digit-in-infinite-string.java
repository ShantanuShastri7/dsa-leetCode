class Solution {
    public int kthDigit(long k) {
        long l = 0;
        // Make sure 'r' is large enough to handle extreme constraints for k
        long r = 1000000000000000L; 
        long res = 0;

        // Binary Search finds the exact number of fully appended integers 
        // that come completely BEFORE the k-th digit.
        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (countDigitsUpTo(mid) < k) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // How many digits were used by those first 'res' numbers?
        long usedDigits = countDigitsUpTo(res);
        
        // This is our 1-based index inside the actual target number
        int remDigits = (int) (k - usedDigits); 

        long targetNum = 0;
        
        // Map 'res' (count of numbers) to the ACTUAL number that gets appended
        if (res < 9) {
            // Block 0: Normal increasing order (1 to 9)
            targetNum = res + 1;
        } else {
            // All other blocks have exactly 10 numbers in them
            long b = 1 + (res - 9) / 10;
            long idx = (res - 9) % 10;
            
            if (b % 2 == 0) {
                // Even block: Increasing order (e.g., 20, 21, 22...)
                targetNum = 10 * b + idx;
            } else {
                // Odd block: Decreasing order (e.g., 19, 18, 17...)
                targetNum = 10 * b + 9 - idx;
            }
        }

        // Convert the target number to a string and grab the exact digit
        String s = String.valueOf(targetNum);
        return s.charAt(remDigits - 1) - '0';
    }

    private long countDigitsUpTo(long x) {
        if (x <= 0)
            return 0;

        long totalDigits = 0;
        long length = 1; // Starts at 1-digit numbers
        long start = 1; // Starts at 1, then 10, then 100...

        while (start <= x) {
            long end = (start * 10) - 1; // 9, 99, 999...

            if (x >= end) {
                // 'x' is larger than this whole group. Add the full group's digits!
                long count = end - start + 1;
                totalDigits += count * length;
            } else {
                // 'x' falls somewhere inside this group. Add the remainder and we are done!
                long count = x - start + 1;
                totalDigits += count * length;
            }

            // Move to the next magnitude (e.g., from 10s to 100s)
            length++;
            start *= 10;
        }

        return totalDigits;
    }
}