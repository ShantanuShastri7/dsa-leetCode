class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n = position.length;

        int c = 1;
        for (int i = n - 1; i > 0; i--) {
            if (speed[i] >= speed[i - 1] && position[i] - distance > position[i - 1]) {
                c++;
            } else {
                speed[i - 1] = speed[i];
            }
        }
        return c;
    }
}