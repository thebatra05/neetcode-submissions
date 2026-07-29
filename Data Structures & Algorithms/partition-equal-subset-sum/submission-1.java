class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        Boolean[][] memo = new Boolean[nums.length + 1][target + 1];

        return dfs(nums, target, 0, memo);
    }

    private Boolean dfs(int[] nums, int target, int idx, Boolean[][] memo) {
        if (idx == nums.length) return target == 0;
        if (target < 0) return false;
        if (memo[idx][target] != null) return memo[idx][target];

        memo[idx][target] = dfs(nums, target - nums[idx], idx + 1, memo) || dfs(nums, target, idx + 1, memo);

        return memo[idx][target];
    }
}
