class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(board, 0);
        return res;
    }
    private void solve(char[][] board, int row) {
        // try to place in column and change row + 1 for next recursion
        if (row == board.length) {
            // places all queens
            // take board snapshot and save it in main result
            List<String> temp = new ArrayList<>(construct(board));
            res.add(temp);
            return;
        }

        for (int col = 0; col < board.length; col ++) {
            board[row][col] = 'Q';
            if (isValid(board, row, col)) {
                // go to next thing even if not backtrack
                solve(board, row + 1);
            }
            board[row][col] = '.';
        }
    }
    private boolean isValid(char[][] board, int row, int col) {
        // up column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }  
        return true;     
    }
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
