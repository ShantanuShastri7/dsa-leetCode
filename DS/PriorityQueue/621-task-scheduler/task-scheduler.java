class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        // Count frequency
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // Find max frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Count how many tasks have that frequency
        int maxFreqCount = 0;
        for (int f : freq) {
            if (f == maxFreq) maxFreqCount++;
        }

        // Core formula
        int partCount = maxFreq - 1;
        int partLength = n + 1;
        int emptySlots = partCount * partLength + maxFreqCount;

        return Math.max(tasks.length, emptySlots);
    }
}