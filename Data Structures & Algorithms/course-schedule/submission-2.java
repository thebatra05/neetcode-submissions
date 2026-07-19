class Solution {
    private List<List<Integer>> buildAdjList(int n, int[][] prereqs) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; ++i) adjList.add(new ArrayList<>());
        for (int[] p : prereqs) {
            int u = p[0];
            int v = p[1];
            adjList.get(u).add(v);
        }

        return adjList;
    }
    private boolean isCycle(List<List<Integer>> graph, boolean[] visited, int course) {
        if (visited[course]) return true;

        visited[course] = true;
        for (int neigh : graph.get(course)) {
            if (isCycle(graph, visited, neigh)) return true;
        }
        visited[course] = false;

        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        List<List<Integer>> graph = buildAdjList(numCourses, prerequisites);

        for (int i = 0; i < numCourses; ++i) {
            if (!visited[i]) {
                if (isCycle(graph, visited, i)) return false;
            }
        }

        return true;
    }

    /*
        1 -> [0, 2, 3]

        0   1   2   3
         [0,2,3]
    */

}
