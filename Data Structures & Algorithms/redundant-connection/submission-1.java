class DSU {
    private int[] Parent, Size;
    public DSU (int n) {
        Parent = new int[n];
        Size = new int[n];
        for (int i = 0; i < n; ++i) {
            Parent[i] = i;
            Size[i] = 1;
        }
    }
    private int find(int node) {
        while (node != Parent[node]) {
            node = Parent[node];
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
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n + 1);
        for (int[] edge: edges) {
            if (!dsu.union(edge[0], edge[1])) return edge;
        }

        return new int[2];
    } 

    /*
        [[1,2],[1,3],[3,4],[2,4]]

        0   1   2   3   4
        0   1   1   1   1

        0   1   2   3   4
        1   4   1   1   1
    */
}
