class Solution {
    int maxCount = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    maxCount = Math.max(dfs(grid, r, c, rows, cols), maxCount);
                }
            }
        }
        return maxCount;
    }

    public static int dfs(int[][] grid, int r, int c, int rows, int cols) {
        int count = 0;
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) {
            return 0;
        }
        count++;
        grid[r][c] = 0;

        return count+dfs(grid, r - 1, c, rows, cols) + dfs(grid, r + 1, c, rows, cols)
            + dfs(grid, r, c - 1, rows, cols) + dfs(grid, r, c + 1, rows, cols);
    }
}
