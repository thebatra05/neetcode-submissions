class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int idx) {
        if (idx == word.length()) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(idx))
            return false;
        
        char temp = board[r][c];
        board[r][c] = '#';

        boolean found = dfs(board, r, c + 1, word, idx + 1)
                        || dfs(board, r + 1, c, word, idx + 1)
                        || dfs(board, r, c - 1, word, idx + 1)
                        || dfs(board, r - 1, c, word, idx + 1);

        board[r][c] = temp;

        return found;
    }
}
