class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == '.') continue;
                String key1 = "row: " + String.valueOf(i) + ":" + board[i][j];
                String key2 = "col: " + String.valueOf(j) + ":" + board[i][j];
                String key3 = "gridNum: " + String.valueOf(i/3) + ": " + String.valueOf(j/3) + ":" + board[i][j];
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
