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
}
class Solution {
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        int ans = n;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isConnected[i][j] == 1) {
                    if (dsu.union(i, j)) ans--;
                }
            }
        }

        return ans;
    }

    /*
        0   1   2
    0   1   1   0
    1   1   1   0
    2   0   0   1

    i * COLS + j

    1 * 2 + 1 = 3

           1        0 -> [1]
                    1 -> [0]
                    2 -> []
          /
        0 

        2

    */
}