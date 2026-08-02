class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.add(entry.getValue());
        }

        int ans = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> currentTasks = new ArrayList<>();
            for (int i = 0; i <= n; ++i) {
                if (!maxHeap.isEmpty()) {
                    int freq = maxHeap.poll();
                    --freq;
                    currentTasks.add(freq);
                }
            }
            for (int t : currentTasks) {
                if (t != 0) maxHeap.add(t);
            }
            ans += maxHeap.isEmpty() ? currentTasks.size() : n + 1;
        }

        return ans;
    }

    /*

        2
        2
    */
}
