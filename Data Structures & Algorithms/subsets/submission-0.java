class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> currSubset = new ArrayList<>();

        backtrack(nums, 0, currSubset);

        return result;
    }

    private void backtrack(int[] nums, int idx, List<Integer> currSubset) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(currSubset));
            return;
        }
        currSubset.add(nums[idx]);
        backtrack(nums, idx + 1, currSubset);
        currSubset.remove(currSubset.size() - 1);
        backtrack(nums, idx + 1, currSubset);
    }
}
