class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adjList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; ++i) adjList.add(new ArrayList<>());
        int[] indegree = new int[n + 1];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            if (indegree[i] == 1) q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neigh : adjList.get(node)) {
                indegree[neigh]--;
                if (indegree[neigh] == 1) q.add(neigh);
            }
        }
        
        for (int i = n - 1; i >= 0; --i) {
            int u = edges[i][0], v = edges[i][1];
            if (indegree[u] >= 2 && indegree[v] >= 2) return new int[]{u, v};
        }

        return new int[2];
    } 

    /*
        [[1,2],[1,3],[3,4],[2,4]]

        0   1   2   3   4
            2   2   2   2

        0   1   2   3   4
        0   1   1   1   1

        0   1   2   3   4
        1   4   1   1   1

        1 -> [2, 3]
        2 -> [1, 4]
        3 -> [1]
        4 -> [2]
    */
}
