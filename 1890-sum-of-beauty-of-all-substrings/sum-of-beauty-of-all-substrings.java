class Solution {
    public int beautySum(String s) {
        int sum = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; // frequency array for characters a-z
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        min = Math.min(min, freq[k]);
                        max = Math.max(max, freq[k]);
                    }
                }

                sum += (max - min);
            }
        }

        return sum;
    }
}