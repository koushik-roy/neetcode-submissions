class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, minutes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];
                for (int[] dir : directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) {
                        continue;
                    }
                    if (grid[nr][nc] != 1) {
                        continue;
                    }
                    grid[nr][nc] = 2;
                    fresh--;
                    q.offer(new int[] {nr, nc});
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
