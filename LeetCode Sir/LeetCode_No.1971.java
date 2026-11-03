class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        visited[source] = true;
        q.offer(source);
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == destination) {
                return true;
            }
            for (int ne : graph.get(curr)) {
                if (!visited[ne]) {
                    visited[ne] = true;
                    q.offer(ne);
                }
            }
        }
        return false;
    }
}
