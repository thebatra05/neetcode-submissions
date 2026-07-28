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

        List<Integer> result = new ArrayList<>();

        for (int i = maxFreq; i >= 0; --i) {
            if (bucket.get(i).size() != 0) {
                for (int val : bucket.get(i)) {
                    if (k-- > 0) {
                        result.add(val);
                    }
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /*
        List<List<Integer>>
        0   1   2   3
           [1]  [2] [3]
    */
}
