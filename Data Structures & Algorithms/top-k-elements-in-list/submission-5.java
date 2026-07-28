class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            minHeap.add(new int[]{entry.getValue(), entry.getKey()});
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] result = new int[k];
        int idx = 0;

        while (!minHeap.isEmpty()) {
            result[idx++] = minHeap.poll()[1];
        }

        return result;
    }

    /*
        List<List<Integer>>
        0   1   2   3
           [1]  [2] [3]



    */
}
