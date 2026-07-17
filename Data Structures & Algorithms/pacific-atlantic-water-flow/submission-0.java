class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int lr, lc;
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        lr = heights.length;
        lc = heights[0].length;
        boolean[][] pac = new boolean[lr][lc];
        boolean[][] atl = new boolean[lr][lc];

        //first col
        for (int i = 0; i < lc; i++) {
            dfs(0, i, pac);
        }
        //first row
        for (int i = 0; i < lr; i++) {
            dfs(i, 0, pac);
        }   

        //last col
        for (int i = 0; i < lc; i++) {
            dfs(lr - 1, i, atl);
        }

        //last row
        for (int i = 0; i < lr; i++) {
            dfs(i, lc - 1, atl);
        }
        for (int i = 0; i < lr; i++) {
            for (int j = 0; j < lc; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void dfs(int row, int col, boolean[][] visited) {
        if (row < 0 || row >= lr || col < 0 || col >= lc)
            return;
        if (visited[row][col])
            return;

        visited[row][col] = true;
        for (int[] dir : directions) {
            int nr = dir[0] + row;
            int nc = dir[1] + col;
            if (nr >= 0 && nr < lr && nc >= 0 && nc < lc && heights[nr][nc] >= heights[row][col])
                dfs(nr, nc, visited);
        }
    }
}
