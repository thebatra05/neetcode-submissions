class Solution {
    public int maxSubArray(int[] nums) {
        boolean allNegative = true;
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > 0) allNegative = false;
            maxNum = Math.max(maxNum, num);
        }

        if (allNegative) return maxNum;

        int currSum = 0;
        int ans = 0;

        for (int num : nums) {
            currSum += num;
            if (currSum < 0) currSum = 0;
            ans = Math.max(ans, currSum);
        }

        return ans;
    }
}
