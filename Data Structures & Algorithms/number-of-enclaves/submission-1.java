class Solution {
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; ++i) {
            if (grid[i][0] == 1) q.add(new int[]{i, 0});
            if (grid[i][n - 1] == 1) q.add(new int[]{i, m - 1});
        }
        for (int j = 0; j < n; ++j) {
            if (grid[0][j] == 1) q.add(new int[]{0, j});
            if (grid[m - 1][j] == 1) q.add(new int[]{m - 1, j});
        }

        while (!q.isEmpty()) {
            int[] data = q.poll();
            int r = data[0], c = data[1];
            grid[r][c] = -1;
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != 1) continue;
                grid[nr][nc] = -1;
                q.add(new int[]{nr, nc});
            }
        }

        int count = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) count++;
            }
        }

        return count;
    }

    /*
        [0,0,0,0,0,0]
        [0,1,1,1,1,0]
        [0,1,0,0,1,0]
        [0,1,1,1,1,0]
        [0,0,0,0,0,0]

    */
}