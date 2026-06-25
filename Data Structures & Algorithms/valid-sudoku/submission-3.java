class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        // Set<String> set = new HashSet<>();

        // for (int i = 0; i < m; ++i) {
        //     for (int j = 0; j < m; ++j) {
        //         if (board[i][j] == '.') continue;
        //         String key1 = "row: " + i + ":" + board[i][j];
        //         String key2 = "col: " + j + ":" + board[i][j];
        //         String key3 = "gridNum: " + i/3 + ": " + j/3 + ":" + board[i][j];
        //         if (set.contains(key1) || set.contains(key2) || set.contains(key3))
        //             return false;
        //         set.add(key1);
        //         set.add(key2);
        //         set.add(key3);
        //     }
        // }
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> grids = new HashMap<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == '.') continue;
                String gridsKey = i/3 + "," + j/3;
                if (rows.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j]) || 
                cols.computeIfAbsent(j, k -> new HashSet<>()).contains(board[i][j]) ||
                grids.computeIfAbsent(gridsKey, k -> new HashSet<>()).contains(board[i][j]))
                    return false;
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                grids.get(gridsKey).add(board[i][j]);
            }
        }

        return true;
    }
}
