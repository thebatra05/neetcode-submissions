class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) adjList.add(new ArrayList<>());

        for (int[] edge : prerequisites) {
            indegree[edge[0]]++;
            adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int course = q.poll();
            result.add(course);
            for (int neigh : adjList.get(course)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) q.add(neigh);
            }
        }

        return result.size() == numCourses ? result.stream().mapToInt(Integer::intValue).toArray() : new int[]{};
    }
}
