class Solution {
    private List<List<Integer>> buildAdjList(int n, int[][] prereqs) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; ++i) adjList.add(new ArrayList<>());
        for (int[] p : prereqs) {
            int courseX = p[1];
            int courseDependsOnX = p[0];
            adjList.get(courseX).add(courseDependsOnX);
        }

        return adjList;
    }
    private int[] buildIndegree(int n, List<List<Integer>> adjList) {
        int[] indegree = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int course : adjList.get(i)) indegree[course]++;
        }
        return indegree;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = buildAdjList(numCourses, prerequisites);
        int[] indegree = buildIndegree(numCourses, adjList);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) q.add(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            count += 1;
            for (int neigh : adjList.get(course)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) q.add(neigh);
            }
        }

        return count == numCourses;
    }

    /*
        1 -> [0, 2, 3]

        0   1   2   3
         [0,2,3]
    */

}
