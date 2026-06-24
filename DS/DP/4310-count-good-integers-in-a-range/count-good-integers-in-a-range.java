class Solution {
    public long goodIntegers(long l, long r, int k) {
        String R = String.valueOf(r);
        String L = String.valueOf(l - 1);
        long[][][][] memo1 = new long[R.length()][11][2][2];
        long[][][][] memo2 = new long[L.length()][11][2][2];

        for (long[][][] arr3D : memo1) {
            for (long[][] arr2D : arr3D) {
                for (long[] arr1D : arr2D) {
                    Arrays.fill(arr1D, -1);
                }
            }
        }

        for (long[][][] arr3D : memo2) {
            for (long[][] arr2D : arr3D) {
                for (long[] arr1D : arr2D) {
                    Arrays.fill(arr1D, -1);
                }
            }
        }

        long countR = helper(R, 0, -1, k, true, true, memo1);
        long countL = helper(L, 0, -1, k, true, true, memo2);

        return countR - countL;
    }

    private long helper(String limit, int index, int prev, int k, boolean isTight, boolean leadingZero,
            long[][][][] memo) {
        if (index == limit.length()) {
            return leadingZero ? 0 : 1;
        }
        if (memo[index][prev + 1][isTight ? 1 : 0][leadingZero ? 1 : 0] != -1)
            return memo[index][prev+1][isTight?1:0][leadingZero?1:0];
        long count = 0;

        int upperBound = isTight ? (limit.charAt(index) - '0') : 9;

        for (int i = 0; i <= upperBound; i++) {

            boolean nextTight = isTight && (i == upperBound);
            boolean nextLeadingZero = leadingZero && (i == 0);

            if (leadingZero) {
                count += helper(limit, index + 1, i, k, nextTight, nextLeadingZero, memo);
            } else {
                if (Math.abs(prev - i) <= k) {
                    count += helper(limit, index + 1, i, k, nextTight, nextLeadingZero, memo);
                }
            }
        }

        return memo[index][prev + 1][isTight?1:0][leadingZero?1:0] = count;
    }
}