class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length() + 1];
        return helper(s, wordSet, 0, memo);
    }

    private boolean helper(String s, Set<String> wordSet, int index, Boolean[] memo) {
        if (index == s.length()) return true;
        if (memo[index] != null) return memo[index];

        for (int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index, i);
            if (wordSet.contains(word) && helper(s, wordSet, i, memo)) {
                return memo[index] = true;
            }
        }

        return memo[index] = false;
    }
}