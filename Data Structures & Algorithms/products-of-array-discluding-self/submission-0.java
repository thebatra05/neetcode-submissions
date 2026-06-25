class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(result, 1);
        for (int i = 1; i < n; ++i) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int prod = 1;
        for (int i = n - 1; i >= 0; --i) {
            result[i] = prod * result[i];
            prod *= nums[i];
        }

        return result;
    }
}  
