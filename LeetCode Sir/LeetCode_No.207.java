class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {

            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];

            graph.get(pre).add(course);

            indegree[course]++;
        }

        ArrayList<Integer> queue = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        int index = 0;

        while (index < queue.size()) {

            int node = queue.get(index);
            index++;

            count++;

            for (int neighbor : graph.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return count == numCourses;
    }
}
