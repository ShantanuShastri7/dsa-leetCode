class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;
        char midChar = 0; // Fix 1: Store the middle character completely separately

        for (int i = 0; i < 26; i++) {
            if (chars[i] % 2 != 0) {
                oddCount++;
                midChar = (char) (i + 'a');
            }
            chars[i] /= 2; // Only valid pairs go into the pool for the left half
        }

        if (oddCount > 1) {
            return ""; // Not a valid palindrome permutation
        }

        StringBuilder left = new StringBuilder();
        boolean diverged = false;
        int halfLen = s.length() / 2;

        // 1. Forward Pass (Greedy Prefix Match)
        for (int i = 0; i < halfLen; i++) {
            int t = target.charAt(i) - 'a';

            if (chars[t] > 0) {
                left.append((char) (t + 'a'));
                chars[t]--;
            } else {
                int next = nextGreater(chars, target.charAt(i));
                if (next != -1) {
                    left.append((char) (next + 'a'));
                    chars[next]--;
                    diverged = true;
                }
                break;
            }
        }

        // Fix 2: If we perfectly matched the left half, check the FULL palindrome!
        if (!diverged && left.length() == halfLen) {
            String fullPalindrome = buildPalindrome(left.toString(), midChar);
            if (fullPalindrome.compareTo(target) > 0) {
                return fullPalindrome; // It is naturally greater, we win!
            }
        }

        // 2. Backward Pass (Backtracking)
        // We drop in here if we failed to match, OR if the perfect match wasn't greater
        while (!diverged) {
            if (left.length() == 0) {
                return ""; // Backtracked all the way to the start, mathematically impossible
            }
            
            char lastChar = left.charAt(left.length() - 1);
            chars[lastChar - 'a']++;
            left.deleteCharAt(left.length() - 1);

            int next = nextGreater(chars, target.charAt(left.length()));
            if (next != -1) {
                left.append((char) (next + 'a'));
                chars[next]--;
                diverged = true;
            }
        }

        // 3. Complete the string (Fill remaining pool alphabetically)
        for (int i = 0; i < 26; i++) {
            while (chars[i] > 0) {
                left.append((char) (i + 'a'));
                chars[i]--;
            }
        }

        return buildPalindrome(left.toString(), midChar);
    }

    private int nextGreater(int[] chars, char c) {
        for (int i = c - 'a' + 1; i < 26; i++) {
            if (chars[i] > 0) {
                return i;
            }
        }
        return -1;
    }

    private String buildPalindrome(String left, char midChar) {
        StringBuilder sb = new StringBuilder(left);
        if (midChar != 0) {
            sb.append(midChar);
        }
        // Append the mirrored left half
        for (int i = left.length() - 1; i >= 0; i--) {
            sb.append(left.charAt(i));
        }
        return sb.toString();
    }
}