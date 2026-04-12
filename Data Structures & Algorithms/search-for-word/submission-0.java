class Solution {

    // at every point i have 4 options to move
    // left, right, top, down
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (board[i][j] == word.charAt(0)) {
                    System.out.println(i + ", " + j);
                    if (isExist(board, word, i, j, 1, new boolean[row][col])) return true;
                }
            }
        }
        return false;
    }
    private boolean isExist(char[][] board, String word, int x, int y, int index, boolean[][] visited) {
        if (index == word.length()) return true;
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int newx = x + dir[0];
            int newy = y + dir[1];
            // if not visited and is match my cahr then go ahad
            if (newx >= 0 && newx < board.length && newy >= 0 && newy < board[0].length && !visited[newx][newy] && board[newx][newy] == word.charAt(index)) {
                if (isExist(board, word, newx, newy, index + 1, visited)) return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
}
