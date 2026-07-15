class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (int)((Math.pow(b[0], 2) + Math.pow(b[1], 2)) - (Math.pow(a[0], 2) + Math.pow(a[1], 2))));
        List<int[]> result = new ArrayList<>();

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) maxHeap.poll();
        }

        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }

        return result.toArray(new int[0][]);
    }
}
