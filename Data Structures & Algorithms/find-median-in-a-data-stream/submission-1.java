class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (!minHeap.isEmpty() && num > minHeap.peek()) {
            minHeap.add(num);
        } else maxHeap.add(num);

        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }
        else if (minHeap.size() > maxHeap.size())
            return (double) minHeap.peek();
        else return (double) maxHeap.peek();
    }

    /*
        maxHeap     minHeap


           -2        -3
                    -1

    */
}
