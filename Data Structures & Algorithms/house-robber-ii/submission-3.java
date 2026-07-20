class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        int[] memo1 = new int[n];
        Arrays.fill(memo1, -1);
        int[] memo2 = new int[n];
        Arrays.fill(memo2, -1);
        return Math.max(dfs(nums, 0, n - 2, memo1), dfs(nums, 1, n - 1, memo2));
    }

    int dfs(int[] nums, int start, int end, int[] memo) {
        if (start > end) return 0;
        if (memo[start] != -1) return memo[start];

        return memo[start] = Math.max(nums[start] + dfs(nums, start + 2, end, memo), dfs(nums, start + 1, end, memo));
    }

    /*
        0 -- > n - 2
        1 -- > n - 1
    */
}
