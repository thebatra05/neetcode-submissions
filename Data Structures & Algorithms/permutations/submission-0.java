class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;

        backtrack(nums, new ArrayList<>(), new boolean[n]);

        return result;
    }

    private void backtrack(int[] nums, List<Integer> curr, boolean[] visited) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                curr.add(nums[i]);
                backtrack(nums, curr, visited);
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    /*
        1, 2, 3

    */
}
