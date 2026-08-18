class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; ++i) {
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) dq.removeLast();
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.removeFirst();
            dq.addLast(i);
            if (i >= k - 1) result[idx++] = nums[dq.peekFirst()];
        }

        return result;
    }

    /*
        0   1   2   3   4   5   6   7
        1   3   -1  -3  5   3   6   7

        1
    */
}