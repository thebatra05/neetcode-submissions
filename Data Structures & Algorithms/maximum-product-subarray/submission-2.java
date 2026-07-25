class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        int maxProd = 1;
        int minProd = 1;

        for (int i = 0; i < n; ++i) {
            int tmp = maxProd * nums[i];
            maxProd = Math.max(maxProd * nums[i], Math.max(minProd * nums[i], nums[i]));
            minProd = Math.min(tmp, Math.min(minProd * nums[i], nums[i]));
            ans = Math.max(ans, maxProd);
        }

        return ans;
        
    }

    /*
        0   1   2   3
        2   4   -3  5

        maxProd = 
        
        
        globalMax
        maxProd
        minProd
        globalMax = max(maxProd * nums[i], minProd * nums[i], nums[i])
        maxProd = max(maxProd * nums[i], minProd * nums[i], nums[i])
        minProd = min(maxProd * nums[i], minProd * nums[i], nums[i])
        
    */
}
