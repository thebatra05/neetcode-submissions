class Solution {
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O') q.add(new int[]{i, 0});
            if (board[i][n - 1] == 'O') q.add(new int[]{i, n - 1});
        }
        for (int j = 0; j < n; ++j) {
            if (board[0][j] == 'O') q.add(new int[]{0, j});
            if (board[m - 1][j] == 'O') q.add(new int[]{m - 1, j});
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0], c = node[1];
            board[r][c] = '#';
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || board[nr][nc] != 'O') continue;
                board[nr][nc] = '#';
                q.add(new int[]{nr, nc});
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
}
