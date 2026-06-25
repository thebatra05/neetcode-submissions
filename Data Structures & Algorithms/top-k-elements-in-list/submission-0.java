class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= nums.length; ++i) bucket.add(new ArrayList<>());
        
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) countMap.put(num, countMap.getOrDefault(num, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            bucket.get(entry.getValue()).add(entry.getKey());
        }

        List<Integer> result = new ArrayList<>();

        for (int i = nums.length; i >= 0; --i) {
            if (!bucket.get(i).isEmpty()) {
                for (int num : bucket.get(i)) {
                    if (k > 0) {
                        result.add(num);
                        k--;
                    }
                }
            }
            if (k == 0) break;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
