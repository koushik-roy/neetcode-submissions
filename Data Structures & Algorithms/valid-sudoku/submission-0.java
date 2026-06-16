class Solution {
    public boolean isValidSudoku(char[][] board) {
 
        Set<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char num = board[i][j];
                if(num == '.'){
                    continue;
                }
                int blockIdx = i / 3 * 3 + j / 3;
                String row = "row" + i + ":" + num;
                String col = "col" + j + ":" + num;
                String block = "block" + blockIdx + ":" + num;

                if (!set.add(row) || !set.add(col) || !set.add(block)) {
                    return false;
                }
            }
        }
        return true;
    }
}
