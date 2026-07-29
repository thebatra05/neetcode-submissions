class Solution {
    public int lengthOfLIS(int[] nums) {
        int lis = 1;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j], 1 + dp[i]);
                    lis = Math.max(lis, dp[j]);
                }
            }
        }

        return lis;
    }

    /*
        0   1   2   3   4   5   6
        9   1   4   2   3   3   7
        1   1   1   1   1   1   1
        1   1   2   2   2   2   2
        1   1   2   2   2   2   2
        1   1   2   2   3   3   3
        1   1   2   2   3   4   4
    */
}
