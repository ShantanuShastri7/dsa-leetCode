class Solution {
    public int change(int amount, int[] coins) {
        int[][] mem = new int[amount + 1][coins.length];
        for (int i = 0; i < amount + 1; i++) {
            Arrays.fill(mem[i], -1);
        }

        return helper(amount, coins, coins.length - 1, mem);
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