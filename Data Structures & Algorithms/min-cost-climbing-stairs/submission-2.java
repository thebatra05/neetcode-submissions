class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return Math.min(dfs(cost, 0, memo), dfs(cost, 1, memo));
    }
    private int dfs(int[] cost, int idx, int[] memo) {
        if (idx >= cost.length) return 0;
        if (memo[idx] != -1) return memo[idx];

        memo[idx] = cost[idx] + Math.min(dfs(cost, idx + 1, memo), dfs(cost, idx + 2, memo));

        return memo[idx];
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
