class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (!adjList.containsKey(u)) adjList.put(u, new ArrayList<>());
            if (!adjList.containsKey(v)) adjList.put(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for (int i = 0; i < n; ++i) {
            if (visited[i] == false) {
                dfs(i, adjList, visited);
                count += 1;
            }
        }

        return count;
    }

    private void dfs(int node, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        if (visited[node] == true) return;

        visited[node] = true;
        for (int neigh : adjList.getOrDefault(node, new ArrayList<>())) {
            dfs(neigh, adjList, visited);
        }
    }

    /*

    */
}
