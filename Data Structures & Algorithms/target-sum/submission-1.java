class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        Map<String, Integer> memo = new HashMap<>();

        return helper(nums, 0, target, 0, memo);
    }

    private int helper(int[] nums, int idx, int target, int currSum, Map<String, Integer> memo) {
        if (idx == nums.length) return currSum == target ? 1 : 0;

        String key = idx + "-" + currSum;
        if (memo.containsKey(key)) return memo.get(key);

        int numWays = helper(nums, idx + 1, target, currSum + nums[idx], memo)
                    + helper(nums, idx + 1, target, currSum - nums[idx], memo);

        memo.put(key, numWays);

        return numWays;
    }
}
