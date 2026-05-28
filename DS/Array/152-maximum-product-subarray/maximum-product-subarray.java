class Solution {
    public int maxProduct(int[] nums) {
        int runningMax = nums[0];
        int runningMin = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            // Calculate all three candidates
            int cand1 = current;
            int cand2 = runningMax * current;
            int cand3 = runningMin * current;

            // Update runningMax and runningMin simultaneously
            runningMax = Math.max(cand1, Math.max(cand2, cand3));
            runningMin = Math.min(cand1, Math.min(cand2, cand3));

            // Update the global result
            result = Math.max(result, runningMax);
        }

        return result;
    }
}


// Intuition 2: The "Odd Negative" Rule (Prefix and Suffix Passes)
// There is a completely different, highly visual way to think about this that avoids tracking minimums entirely.

// Pretend there are no zeros in the array for a second:

// If the array has all positive numbers, the max product is the whole array.

// If it has an even number of negative numbers, they all cancel each other out, and the max product is still the whole array.

// But what if it has an odd number of negative numbers?
// To get a positive maximum, you have to get rid of exactly one negative number so the rest can pair up and cancel out. Which one do you exclude? It will always be either the first negative number or the last negative number in the sequence.

// This naturally means the answer is either the product of a prefix (everything up to the last negative) or the product of a suffix (everything after the first negative).
// Therefore, if you just sweep through the array from left-to-right, and then sweep again from right-to-left, the highest product you encounter is guaranteed to be your answer!

// What about Zeros?
// Zeros act as hard resets.
// A zero destroys any product it touches. Whether you are using the Min/Max approach or the Left/Right approach, a zero means "this contiguous subarray is dead." You simply evaluate the zero, and then reset your running product tracker back to 1 so you can start fresh on the very next number.