class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i <= n; ++i) dp[i][0] = true;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= target; ++j) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
                else dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][target];
    }

    private boolean dfs(int[] nums, int target, int idx, Boolean[][] memo) {
        if (idx == nums.length) return target == 0;
        if (target < 0) return false;
        if (memo[idx][target] != null) return memo[idx][target];

        memo[idx][target] = dfs(nums, target - nums[idx], idx + 1, memo) || dfs(nums, target, idx + 1, memo);

        return memo[idx][target];
    }
}
