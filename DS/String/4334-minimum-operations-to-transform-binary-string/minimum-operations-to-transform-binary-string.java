class Solution {
    public int minOperations(String s1, String s2) {
        int ops = 0;
        int n = s1.length();
        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();

        for (int i = 0; i < n; i++) {
            if (s1c[i] == s2c[i]) {
                continue;
            } else if (s1c[i] == '0' && s2c[i] == '1') {
                s1c[i] = '1';
                ops++;
            } else if (s1c[i] == '1' && s2c[i] == '0') {
                if (i == n - 1) {
                    if (n == 1) return -1;
                    ops += 2;
                } else {
                    if (s1c[i + 1] == '1') {
                        s1c[i] = '0';
                        s1c[i + 1] = '0';
                        ops += 1;
                    } else {
                        s1c[i] = '0';
                        s1c[i + 1] = '0';
                        ops += 2;
                    }
                }
            }
        }

        return ops;
    }
}