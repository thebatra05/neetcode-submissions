class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int mid = 0;

        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] <= nums[high]) high = mid;
            else low = mid + 1;
        }

        return nums[low];
    }

    /*
            0   1   2   3   4   5
            1   2   3   4   5   6   mid = 2

            0   1   2   3   4   5
            3   4   5   6   1   2   mid = 2
    */
}
