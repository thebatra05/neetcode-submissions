class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; ++i) {
            int lastEnd = result.get(result.size() - 1)[1];
            int lastStart = result.get(result.size() - 1)[0];
            int currStart = intervals[i][0], currEnd = intervals[i][1];
            if (lastEnd >= currStart) {
                int[] newInterval = new int[]{lastStart, Math.max(lastEnd, currEnd)};
                result.remove(result.size() - 1);
                result.add(newInterval);
            }
            else result.add(intervals[i]);
        }

        return result.toArray(new int[0][]);

        /*
            1------3
            1------------5
        */
    }
}
