class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            int prod = 1;
            for (int j = i; j < n; ++j) {
                prod *= nums[j];
                ans = Math.max(ans, prod);
            }
        }

        return ans;
    }

    /*
        0   1   2   3
        2   4   -3  5
        l
        r
    */
}
