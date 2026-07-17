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

        for (int i = idx; i < candidates.length; ++i) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            if (target - candidates[i] < 0) break;
            
            currComb.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, currComb);
            currComb.remove(currComb.size() - 1);
        }


    
    }
}
