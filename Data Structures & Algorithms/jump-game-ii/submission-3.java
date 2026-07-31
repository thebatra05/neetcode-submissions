class Solution {
    public int jump(int[] nums) {
        int l = 0, r = 0;
        int farthest = 0;
        int n = nums.length;
        int count = 0;

        while (r < n - 1) {
            while (l <= r) {
                farthest = Math.max(farthest, l + nums[l]);
                l += 1;
            }
            l = r + 1;
            r = farthest;
            count += 1;
        }

        return count;
    }

    /*

        0   1   2   3   4   5
        2   4   1   1   1   1

        l=0,r=0
        l<=r -> farthest=2,l=1,r=2,count=1
        1<=2 -> farhest=5,l=3,r=5

        count=6
        j=1;j<=2
        count=min(count,1+dfs(nums,1))
            j=2;j<=5
            count=min(count,1+dfs(nums,2))
                j=3;j<=3
                count=min(count,1+dfs(nums,3))
                    

    */
}
