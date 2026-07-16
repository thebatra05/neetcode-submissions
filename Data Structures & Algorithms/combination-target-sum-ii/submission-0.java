class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] candidates, int target, int idx, List<Integer> currComb) {
        if (target == 0) {
            result.add(new ArrayList<>(currComb));
            return;
        }
        if (target < 0 || idx == candidates.length) return;

        currComb.add(candidates[idx]);
        backtrack(candidates, target - candidates[idx], idx + 1, currComb);
        currComb.remove(currComb.size() - 1);

        while (idx + 1 < candidates.length && candidates[idx] == candidates[idx + 1]) idx++;
        
        backtrack(candidates, target, idx + 1, currComb);
    }
}
