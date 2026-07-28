class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProd = new int[n];
        leftProd[0] = 1;
        int[] rightProd = new int[n];
        rightProd[n - 1] = 1;

        for (int i = 1; i < n; ++i) {
            leftProd[i] = nums[i - 1] * leftProd[i - 1];
            rightProd[n - i - 1] = nums[n - i] * rightProd[n - i];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; ++i) result[i] = leftProd[i] * rightProd[i];

        return result;
    }

    /*
        
    */
}  
