class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; ++i) bucket[i] = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }

        int idx = 0;
        int[] res = new int[k];

        for (int i = bucket.length - 1; i >= 0 && idx < k; --i) {
            for (int num : bucket[i]) {
                res[idx++] = num;
                if (idx == k) return res;
            }
        }

        return res;

        // Map<Integer, Integer> count = new HashMap<>();
        // for (int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
        //     pq.offer(new int[]{entry.getValue(), entry.getKey()});
        //     if (pq.size() > k) pq.poll();
        // }

        // int[] res = new int[k];
        // for (int i = 0; i < k; ++i) {
        //     res[i] = pq.poll()[1];
        // }

        // return res;
        
    }
}
