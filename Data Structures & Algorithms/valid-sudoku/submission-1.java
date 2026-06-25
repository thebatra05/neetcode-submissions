class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == '.') continue;
                String key1 = "row: " + i + ":" + board[i][j];
                String key2 = "col: " + j + ":" + board[i][j];
                String key3 = "gridNum: " + i/3 + ": " + j/3 + ":" + board[i][j];
                if (set.contains(key1) || set.contains(key2) || set.contains(key3))
                    return false;
                set.add(key1);
                set.add(key2);
                set.add(key3);
            }
        }

        return true;
    }
}
