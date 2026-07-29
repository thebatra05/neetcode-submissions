class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
        int start = 0, end = heights.length - 1;

        while (start < end) {
            area = Math.max(area, Math.min(heights[start], heights[end]) * (end - start));
            if (heights[start] < heights[end]) start++;
            else end--;
        }

        return area;
    }

    /*
        0 1 2 3 4 5 6 7
        1 7 2 5 4 7 3 6
    */
}
