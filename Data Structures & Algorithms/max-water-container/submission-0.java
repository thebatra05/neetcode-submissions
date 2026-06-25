class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int low = 0, high = n - 1;
        int area = 0;

        while (low < high) {
            area = Math.max(area, Math.min(heights[low], heights[high]) * (high - low));
            if (heights[low] < heights[high]) low++;
            else high--;
        }

        return area;
    }

    /*
        0   1   2   3   4   5   6   7
        1   7   2   5   4   7   3   6
        6 * (7 - 1) = 36
    */
}
