class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int ans = nums[0];

        for (int num : nums) {
            if (currSum < 0) currSum = 0;
            currSum += num;
            ans = Math.max(ans, currSum);
        }

        return ans;
    }
}
