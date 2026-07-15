class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (int)((Math.pow(b[0], 2) + Math.pow(b[1], 2)) - (Math.pow(a[0], 2) + Math.pow(a[1], 2))));
        int[][] result = new int[k][2];

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) maxHeap.poll();
        }

        int idx = 0;
        while (!maxHeap.isEmpty()) {
            int[] point = maxHeap.poll();
            result[idx] = new int[]{point[0], point[1]};
            idx += 1;
        }

        return result;
    }
}
