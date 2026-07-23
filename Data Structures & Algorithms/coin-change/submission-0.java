class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int amt = 1; amt <= amount; ++amt) {
                if (amt >= coin) {
                    dp[amt] = Math.min(dp[amt], dp[amt - coin] == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + dp[amt - coin]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /*

    */
}
