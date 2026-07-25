class Solution {
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    public boolean validTree(int n, int[][] edges) {

        if (edges.length > n - 1) return false;

        Set<Integer> visited = new HashSet<>();
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (!graph.containsKey(u)) graph.put(u, new ArrayList<>());
            if (!graph.containsKey(v)) graph.put(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        if (!dfs(0, -1, visited)) return false;

        return visited.size() == n;
    }

    private boolean dfs(int node, int parent, Set<Integer> visited) {
        if (visited.contains(node)) return false;
        visited.add(node);

        for (int neigh : graph.getOrDefault(node, new ArrayList<>())) {
            if (neigh == parent) continue;
            if (!dfs(neigh, node, visited)) return false;
        }

        return true;
    }

    /*
            0 
           / 
          1 ----   
        /   \
        2 --- 3
    */
}
