class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int l = 0, r = n - 1, t = 0, b = m - 1;

        while (l <= r && t <= b) {
            for (int j = l; j <= r; ++j) {
                result.add(matrix[t][j]);
            }
            t++;
            for (int i = t; i <= b; ++i) {
                result.add(matrix[i][r]);
            }
            r--;
            if (t <= b) {
                for (int j = r; j >= l; --j) {
                    result.add(matrix[b][j]);
                }
                 b--;
            }
            if (l <= r) {
                for (int i = b; i >= t; --i) {
                    result.add(matrix[i][l]);
                }
                l++;
            }
        }
        return result;
    }
}

    /*

        1   2   3
        4   5   6
        7   8   9

    */
