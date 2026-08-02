class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) 
            adjList.add(new ArrayList<>());
        
        for (int[] prereq : prerequisites) {
            int courseX = prereq[1];
            int courseDependsOnX = prereq[0];
            adjList.get(courseX).add(courseDependsOnX);
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            for (int course : adjList.get(i)) indegree[course]++;
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

        int[] res = result.size() == numCourses ? result.stream().mapToInt(Integer::intValue).toArray() : new int[]{};

        return res;
    }

    /*

        b -> a

    */
}
