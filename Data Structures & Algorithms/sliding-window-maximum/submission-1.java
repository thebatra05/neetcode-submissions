class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n; ++i) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.removeFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.removeLast();
            dq.addLast(i);
            if (i >= k - 1) result[i - k + 1] = nums[dq.peekFirst()];
        }

        return result;
    }

    /*
         0 1 2 3 4 5 6
        [1,2,1,0,4,2,6]
        idx, value
        (1, 2) (2, 1) ()

        2, 2
    */
}
