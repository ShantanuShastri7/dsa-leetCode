class Solution {
    public int change(int amount, int[] coins) {
        int[][] mem = new int[amount + 1][coins.length];
        for (int i = 0; i < coins.length; i++) {
            mem[0][i] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            if (i % coins[0] == 0) {
                mem[i][0] = 1;
            }
        }

        for (int i = 0; i <= amount; i++) {
            for (int j = 1; j < coins.length; j++) {

                int pick = 0;
                if (i >= coins[j]) {
                    pick = mem[i-coins[j]][j];
                }

                int notPick = mem[i][j-1];

                mem[i][j] = pick + notPick;
            }
        }

        return mem[amount][coins.length-1];
    }

    private int helper(int amount, int[] coins, int index, int[][] mem) {
        if (amount == 0)
            return 1;
        if (index == 0) {
            if (amount == 0)
                return 1;
            else if (amount % coins[index] == 0)
                return 1;
            else
                return 0;
        }

        if (mem[amount][index] != -1)
            return mem[amount][index];

        int pick = 0;
        if (amount >= coins[index]) {
            pick = helper(amount - coins[index], coins, index, mem);
        }

        int notPick = helper(amount, coins, index - 1, mem);

        return mem[amount][index] = pick + notPick;
    }
}