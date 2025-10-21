class Solution {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        Pair[] list = new Pair[n];

        for (int i = 0; i < n; i++) {
            list[i] = new Pair(start[i], end[i]);
        }

        Arrays.sort(list, (a, b) -> a.second - b.second);

        int count = 1;
        int lastEnd = list[0].second;

        for (int i = 1; i < n; i++) {
            if (list[i].first > lastEnd) {
                count++;
                lastEnd = list[i].second;
            }
        }

        return count;
    }

    class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
