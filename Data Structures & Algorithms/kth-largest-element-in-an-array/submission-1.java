class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int pivotIdx = n;
        int l = 0, r = n - 1;

        while (pivotIdx != n - k) {
            pivotIdx = partition(nums, l, r);
            if (pivotIdx == n - k) return nums[pivotIdx];
            else if (pivotIdx > n - k) r = pivotIdx - 1;
            else l = pivotIdx + 1;
        }

        return 0;
    }

    private int partition(int[] nums, int l, int r) {
        int i = l;
        int pivotIdx = r;

        for (int j = l; j < r; ++j) {
            if (nums[j] <= nums[pivotIdx]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        int temp = nums[i];
        nums[i] = nums[pivotIdx];
        nums[pivotIdx] = temp;

        return i;
    }

    /*


        4
        5
    */
}
