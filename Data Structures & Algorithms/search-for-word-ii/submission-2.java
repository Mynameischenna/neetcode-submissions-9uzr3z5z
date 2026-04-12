class Solution {
    Set<String> res = new HashSet<>();
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public List<String> findWords(char[][] board, String[] words) {
        int row = board.length, col = board[0].length;

        for (String s : words) {
            char start = s.charAt(0);
            boolean found = false;

            for (int i = 0; i < row && !found; i++) {
                for (int j = 0; j < col && !found; j++) {

                    if (board[i][j] == start) {
                        boolean[][] visited = new boolean[row][col];
                        visited[i][j] = true;

                        if (isValid(board, i, j, s, 1, visited)) {
                            res.add(s);
                            found = true;
                        }
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }

    private boolean isValid(char[][] board, int row, int col, String s, int index, boolean[][] visited) {
        if (index == s.length()) return true;

        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];

            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length &&
                !visited[x][y] && board[x][y] == s.charAt(index)) {

                visited[x][y] = true;

                if (isValid(board, x, y, s, index + 1, visited)) return true;

                visited[x][y] = false;
            }
        }
        return false;
    }
}