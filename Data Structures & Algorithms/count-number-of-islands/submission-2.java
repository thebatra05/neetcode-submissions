class DSU {
    private int[] Parent, Size;
    public DSU(int n) {
        Parent = new int[n];
        Size = new int[n];
        for (int i = 0; i < n; ++i) {
            Parent[i] = i;
            Size[i] = 1;
        }
    }

    private int find(int node) {
        if (node != Parent[node]) {
            Parent[node] = find(Parent[node]);
        }
        return Parent[node];
    }

    private boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) return false;
        if (Size[pu] >= Size[pv]) {
            Size[pu] += Size[pv];
            Parent[pv] = pu;
        }
        else {
            Size[pv] += Size[pu];
            Parent[pu] = pv;
        }
        return true;
    }
    /*

        0   1   2   3   4
        0   0   0   0   0
        find(4)
        Parent

    */
}
class Solution {
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        DSU dsu = new DSU(m * n);

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    count += 1;
                    for (int[] dir : directions) {
                        int nr = i + dir[0], nc = j + dir[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != '1') continue;
                        if (dsu.union(i * n + j, nr * n + nc)) {
                            count -= 1;
                        }
                    }
                }
            }
        }

        return count;
    }
}
