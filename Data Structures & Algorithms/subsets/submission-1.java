class Solution {
    

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; ++i) {
                List<Integer> currSubset = new ArrayList<>(result.get(i));
                currSubset.add(num);
                result.add(currSubset);
            }
        }

        return result;
    }

    /*
            [[], [1], [2], [1,2]]   2
    */

}
