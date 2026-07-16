class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char t : tasks) countMap.put(t, countMap.getOrDefault(t, 0) + 1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            maxHeap.add(entry.getValue());
        }

        int ans = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n + 1; ++i) {
                if (!maxHeap.isEmpty()) {
                    int freq = maxHeap.poll();
                    temp.add(--freq);
                }
            }

            for (int val : temp) {
                if (val != 0) maxHeap.add(val);
            }
            ans += maxHeap.isEmpty() ? temp.size() : n + 1;
        }

        return ans;
    }

    /*

        2
        2

        1, 1
    */
}
