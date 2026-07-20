class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(nums, 0, memo);
    }

    int dfs(int[] nums, int idx, int[] memo) {
        if (idx >= nums.length) return 0;
        if (memo[idx] != -1) return memo[idx];

        return memo[idx] = Math.max(nums[idx] + dfs(nums, idx + 2, memo), dfs(nums, idx + 1, memo));
    }

    /*
        0   1   2   3
        1   1   3   3

    */
}
