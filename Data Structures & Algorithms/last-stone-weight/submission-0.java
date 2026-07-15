class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) maxHeap.add(stone);

        while (maxHeap.size() > 1) {
            int top = maxHeap.poll();
            int secondTop = maxHeap.poll();
            int diff = top - secondTop;
            if (diff > 0) maxHeap.add(diff);
        } 

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
