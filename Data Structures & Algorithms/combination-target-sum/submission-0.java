class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] nums, int target, int idx, List<Integer> currComb) {
        if (target < 0 || idx == nums.length) return;

        if (target == 0) {
            result.add(new ArrayList<>(currComb));
            return;
        }

        currComb.add(nums[idx]);
        backtrack(nums, target - nums[idx], idx, currComb);
        currComb.remove(currComb.size() - 1);
        backtrack(nums, target, idx + 1, currComb);
    }

    /*
        [2, 5, 6, 9]    target = 9

    */
}
