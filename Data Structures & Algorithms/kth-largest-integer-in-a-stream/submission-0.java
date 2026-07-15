class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
    }

    /*

        3
        3
    */
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) pq.poll();

        return pq.peek();
    }
}
