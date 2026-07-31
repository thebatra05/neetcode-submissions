class Solution {
    public int jump(int[] nums) {
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return dfs(nums, 0, memo);
    }

    private int dfs(int[] nums, int idx, int[] memo) {
        if (idx >= nums.length - 1) return 0;

        if (memo[idx] != -1) return memo[idx];

        int maxJump = Math.min(nums.length - 1, idx + nums[idx]);
        int count = nums.length;
        for (int j = idx + 1; j <= maxJump; ++j) {
            count = Math.min(count, 1 + dfs(nums, j, memo));
        }

        memo[idx] = count;

        return count;
    }

    /*

        0   1   2   3   4   5
        2   4   1   1   1   1

        count=6
        j=1;j<=2
        count=min(count,1+dfs(nums,1))
            j=2;j<=5
            count=min(count,1+dfs(nums,2))
                j=3;j<=3
                count=min(count,1+dfs(nums,3))
                    

    */
}
