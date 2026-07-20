class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 2; i < n + 2; ++i) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
            maxValue = Math.max(maxValue, dp[i]);
        }

        return maxValue;
    }

    /*
        0   1   2   3
        1   1   3   3


0   0   1   1   4   4   

        Math.max(dp[i - 2] + nums[i], dp[i - 1])
    */
}
