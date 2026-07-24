class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean backtrack(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];

        board[row][col] = '0';

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (backtrack(board, word, index + 1, newRow, newCol)) {
                return true;
            }
        }

        board[row][col] = temp;
        return false;
    }
}
