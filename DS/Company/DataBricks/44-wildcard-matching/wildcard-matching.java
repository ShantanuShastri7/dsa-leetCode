class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return helper(s, p, 0, 0, memo);
    }

    private boolean helper(String s, String p, int i, int j, Boolean[][] memo) {
        if (memo[i][j] != null) return memo[i][j];

        if (i == s.length() && j == p.length()) return memo[i][j] = true;

        if (j == p.length()) return memo[i][j] = false;

        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') return memo[i][j] = false;
            }
            return memo[i][j] = true;
        }

        boolean match;

        if (p.charAt(j) == '*') {
            match = helper(s, p, i + 1, j, memo) || helper(s, p, i, j + 1, memo);
        } else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
            match = helper(s, p, i + 1, j + 1, memo);
        } else {
            match = false;
        }

        return memo[i][j] = match;
    }
}