class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxFreq = 0;
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(countMap.get(num), maxFreq);
        }

        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxFreq; ++i) {
            bucket.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int freq = entry.getValue();
            int val = entry.getKey();
            bucket.get(freq).add(val);
        }

        int[] result = new int[k];
        int idx = 0;

        for (int i = maxFreq; i >= 0 && idx < k; --i) {
                for (int val : bucket.get(i)) {
                    result[idx++] = val;
                    if (idx == k) return result;
                }
        }

        return result;
    }

    /*
        List<List<Integer>>
        0   1   2   3
           [1]  [2] [3]
    */
}
