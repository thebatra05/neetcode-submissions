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
    public int countComponents(int n, int[][] edges) {
        int ans = n;
        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) ans -= 1;
        }

        return ans;
    }


    /*
        0   1   2   3   4
        0   0   0   3   3

        0   1   2   3
        1   1   1   1

        0 -> 1
    */
}
