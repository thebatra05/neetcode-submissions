class Solution {
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int j = 0; j < n; ++j) {
            dfs(heights, 0, j, pacific);
            dfs(heights, m - 1, j, atlantic);
        }

        for (int i = 0; i < m; ++i) {
            dfs(heights, i, 0, pacific);
            dfs(heights, i, n - 1, atlantic);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            } 
        }

        return result;
     }

     private static void dfs(int[][] heights, int i, int j, boolean[][] ocean) {
        ocean[i][j] = true;
        for (int[] dir : directions) {
            int nr = i + dir[0], nc = j + dir[1];
            if (nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length || heights[nr][nc] < heights[i][j] || ocean[nr][nc]) continue;
            dfs(heights, nr, nc, ocean);
        }
     }
}
