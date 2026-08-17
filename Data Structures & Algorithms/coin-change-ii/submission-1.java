class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[amount + 1][coins.length + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return helper(coins, 0, amount, memo);
    }

    private int helper(int[] coins, int idx, int amount, int[][] memo) {
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        if (idx == coins.length) return 0;

        if (memo[amount][idx] != -1) return memo[amount][idx];

        int numWays = 0;
        if (amount >= coins[idx]) {
            numWays += helper(coins, idx, amount - coins[idx], memo);
        }
        numWays += helper(coins, idx + 1, amount, memo);

        memo[amount][idx] = numWays;

        return numWays;
    }
}
