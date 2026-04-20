class Solution {
    // marking cell as T menas O , remaining O's you can cahnge to X
    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        for (int i = 0; i < col; i ++) {
           if (board[0][i] == 'O') {
            capture(board, 0, i);
           }
           if (board[row - 1][i] == 'O') {
            capture(board, row - 1, i);
           }
        }
         for (int j = 0; j < row; j ++) {
              if (board[j][0] == 'O') {
            capture(board, j, 0);
           }
           if (board[j][col - 1] == 'O') {
            capture(board, j, col - 1);
           } 
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
    private void capture(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') return;

        board[row][col] = 'T';
        capture(board, row + 1, col);
        capture(board, row -1 , col);
        capture(board, row, col + 1);
        capture(board, row, col - 1);

    }
}
