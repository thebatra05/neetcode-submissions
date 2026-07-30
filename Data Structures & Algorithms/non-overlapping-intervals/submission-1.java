class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int ans = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; ++i) {
            if (prevEnd > intervals[i][0]) {
                ans += 1;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            }
            else prevEnd = intervals[i][1];
        }

        return ans;
    }

    /*

        [[1,2],[2,4],[1,4]]

        1----2
        1----------4
             2-----4

        [[0,2],[1,3],[2,4],[3,5],[4,6]]

        0--------2
    
                 2------------4
                         3------------5
                              4----------------6
    */
}
