class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> grids = new HashMap<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '.') continue;
                String gridNum = i/3 + "," + j/3;
                if (!rows.containsKey(i)) rows.put(i, new HashSet<>());
                if (!cols.containsKey(j)) cols.put(j, new HashSet<>());
                if (!grids.containsKey(gridNum)) grids.put(gridNum, new HashSet<>());
                if (rows.get(i).contains(board[i][j]) || cols.get(j).contains(board[i][j]) || grids.get(gridNum).contains(board[i][j])) return false;
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                grids.get(gridNum).add(board[i][j]);
            }
        }

        return true;
    }
}
