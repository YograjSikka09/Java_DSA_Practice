class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();

        boolean[] visited = new boolean[n];

        ArrayList<Integer> list = new ArrayList<>();

        list.add(0);
        visited[0] = true;

        int index = 0;

        while (index < list.size()) {

            int room = list.get(index);
            index++;

            for (int key : rooms.get(room)) {

                if (!visited[key]) {

                    visited[key] = true;
                    list.add(key);

                }
            }
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}
