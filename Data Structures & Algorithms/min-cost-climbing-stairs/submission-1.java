class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = cost;

        for (int i = n - 3; i >= 0; --i) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }

        return Math.min(dp[0], dp[1]);
    }

    /*
        0   1 
        1   2 

        0   1
        1   2

        0   1   2   3   4   5   6
        1   2   1   2   1   1   1
        4   5   3   3   2   1   1
    */
}
