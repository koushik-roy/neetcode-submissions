class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int islandCount = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islandCount++;
                    dfs(grid, r, c, rows, cols);
                }
            }
        }

        return islandCount;
    }

    public static void dfs(char[][] grid, int r, int c, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return;
        }
        if (grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c, rows, cols); // up
        dfs(grid, r + 1, c, rows, cols); // down
        dfs(grid, r, c - 1, rows, cols); // left
        dfs(grid, r, c + 1, rows, cols); // right
    }
}
