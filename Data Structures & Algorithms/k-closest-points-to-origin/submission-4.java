class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int pivotIdx = points.length;
        int l = 0, r = points.length - 1;

        while (pivotIdx != k) {
            pivotIdx = partition(points, l, r);
            if (pivotIdx < k) l = pivotIdx + 1;
            else r = pivotIdx - 1;
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; ++i) {
            result[i] = points[i];
        }

        return result;
    }

    private int partition(int[][] points, int l, int r) {
        int pivotIdx = r;

        int i = l;
        for (int j = l; j < r; ++j) {
            if (distance(points[j]) <= distance(points[pivotIdx])) {
                int[] temp = points[i];
                points[i] = points[j];
                points[j] = temp;
                i++;
            }
        }

        int[] temp = points[i];
        points[i] = points[r];
        points[r] = temp;
        return i;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
