class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] res = new int[3];

        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }
            res[0] = Math.max(res[0], t[0]);
            res[1] = Math.max(res[1], t[1]);
            res[2] = Math.max(res[2], t[2]);

            if (res[0] == target[0] && res[1] == target[1] && res[2] == target[2]) {
                return true;
            }
        }

        return false;
    }
}