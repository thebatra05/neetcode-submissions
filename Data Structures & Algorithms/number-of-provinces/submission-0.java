class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j != i && isConnected[i][j] == 1) {
                    if (!graph.containsKey(i)) graph.put(i, new ArrayList<>());
                    graph.get(i).add(j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(visited, i);
                count += 1;
            }
        }

        return count;
    }

    private void dfs(boolean[] visited, int city) {
        if (visited[city]) return;

        visited[city] = true;
        for (int neigh : graph.getOrDefault(city, new ArrayList<>())) {
            if (!visited[neigh]) {
                dfs(visited, neigh);
            }
        }
    }

    /*
        0   1   2
    0   1   1   0
    1   1   1   0
    2   0   0   1

           1        0 -> [1]
                    1 -> [0]
                    2 -> []
          /
        0 

        2

    */
}