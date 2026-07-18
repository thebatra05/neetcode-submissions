class Solution {
    public int climbStairs(int n) {
        int prevOne = 1;
        int prevPrevOne = 1;
        int curr = 1;

        for (int i = 2; i <= n; ++i) {
            curr = prevOne + prevPrevOne;
            prevPrevOne = prevOne;
            prevOne = curr;
        }

        return curr;
    }

    /*
        0   1   2
        0   1   
    */
}
