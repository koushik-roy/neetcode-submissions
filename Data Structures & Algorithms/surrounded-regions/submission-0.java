class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i); // top border
            dfs(board, board.length - 1, i); // bottom border
        }

        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0); // left border
            dfs(board, i, board[0].length - 1); // right border
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        if (board[row][col] != 'O') {
            return;
        }

        board[row][col] = '#'; // mark visited

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(board, newRow, newCol);
        }
    }
}
