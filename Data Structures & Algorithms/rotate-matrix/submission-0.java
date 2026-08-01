class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int l = 0, r = n - 1;
        while (l < r) {
            for (int i = 0; i < n; ++i) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
            }
            l++;
            r--;
        }
    }

    /*

        1   2   3     7  4   1
        4   5   6     8  5   2
        7   8   9     9  6   3

        1   4   7
        2   5   8
        3   6   9

    */
}
