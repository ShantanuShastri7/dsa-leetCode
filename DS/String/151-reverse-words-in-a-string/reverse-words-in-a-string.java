class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        int left = 0;
        int right = 0;
        int n = s.length();

        // Step 1: Push words into stack
        while (left < n && right < n) {
            // Skip spaces
            while (left < n && s.charAt(left) == ' ') {
                left++;
                right = left;
            }
            // Find end of word
            while (right < n && s.charAt(right) != ' ') {
                right++;
            }
            // Add valid word to stack
            if (left < right) {
                st.push(s.substring(left, right));
            }
            left = right;
        }

        // Step 2: Build result
        StringBuilder string = new StringBuilder();
        while (!st.isEmpty()) {
            string.append(st.pop());
            if (!st.isEmpty()) { // only add space between words
                string.append(" ");
            }
        }
        return string.toString();
    }
}