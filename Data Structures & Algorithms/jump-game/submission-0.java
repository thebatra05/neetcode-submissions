class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int last = n - 1;

        for (int i = n - 2; i >= 0; --i) {
            if (i + nums[i] >= last) last = i;
        }

        return last <= 0;
    }

    /*
        0   1   2   3   4
        1   2   0   1   0
                        last = 4
                    i + nums[i] >= last
                        last = i
    */
}
