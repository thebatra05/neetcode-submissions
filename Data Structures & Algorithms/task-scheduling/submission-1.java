class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char t : tasks) countMap.put(t, countMap.getOrDefault(t, 0) + 1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) 
            maxHeap.add(entry.getValue());

        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time += 1;
            if (!maxHeap.isEmpty()) {
                int freq = maxHeap.poll() - 1;
                if (freq > 0) q.add(new int[]{freq, time + n});
            }
            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }

    /*

        2
        2

        1, 1
    */
}
