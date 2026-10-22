class Solution {
    public int minOperations(String s) {
        char min = '1';
        char max = '1';
        int n = s.length();

        for (char c : s.toCharArray()) {
            if (min == '1') {
                min = c;
            }

            if (max == '1') {
                max = c;
            }

            min = (char) Math.min(min, c);
            max = (char) Math.max(max, c);
        }

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);

        if (sorted.equals(s)) {
            return 0;
        }

        if (s.length() == 2 && !sorted.equals(s)) {
            return -1;
        }

        if (s.charAt(0) == max && s.charAt(n - 1) == min
                && s.indexOf(min) == n - 1
                && s.lastIndexOf(max) == 0) {
            return 3;
        }

        if (s.charAt(0) == min || s.charAt(s.length() - 1) == max) {
            return 1;
        }

        return 2;
    }
}