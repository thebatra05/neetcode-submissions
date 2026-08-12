class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int low = 0, hi = n - 1;
        int pivotIdx = n;

        while (pivotIdx != n - k) {
            pivotIdx = partition(nums, low, hi);
            if (pivotIdx == n - k) return nums[pivotIdx];
            else if (pivotIdx > n - k) hi = pivotIdx - 1;
            else low = pivotIdx + 1;
        }

        return -1;
    }

    private int partition(int[] nums, int low, int hi) {
        int i = low;
        int pivotIdx = hi;
        for (int j = low; j < hi; ++j) {
            if (nums[j] <= nums[pivotIdx]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i += 1;
            }
        }

        int temp = nums[i];
        nums[i] = nums[pivotIdx];
        nums[pivotIdx] = temp;
        return i;

    }

    /*
        0   1   2   3   4   5
        3   2   1   5   6   4
                                n = 6
        1   2   3   4   5   6

        6 - 2

    */
}