
import java.util.*;

class Solution {

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        ArrayList<int[]> list = new ArrayList<>();

        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    list.add(new int[]{i, j});
                }

                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int index = 0;

        while (index < list.size() && fresh > 0) {

            int size = list.size();

            while (index < size) {

                int[] current = list.get(index);
                index++;

                int r = current[0];
                int c = current[1];

                for (int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nc >= 0 &&
                        nr < m && nc < n &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;

                        list.add(new int[]{nr, nc});
                    }
                }
            }

            minutes++;
        }

        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}
