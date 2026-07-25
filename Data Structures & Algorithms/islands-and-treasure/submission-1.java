class Solution {
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) q.add(new int[]{i, j});
            }
        }
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] data = q.poll();
                int r = data[0], c = data[1];
                grid[r][c] = level;
                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != Integer.MAX_VALUE) continue;
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = grid[r][c] + 1;
                }
            }

            level += 1;
        }
    }

    /*



    */
}
