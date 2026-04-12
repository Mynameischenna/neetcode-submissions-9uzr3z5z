class Solution {
    boolean[][] visited;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count ++;
                    island(grid, i, j);
                }
            }
        }
        return count;
    }
    private void island(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0' || visited[row][col]) return;

        visited[row][col] = true;

        for (int[] d : dirs) {
            int newx = row + d[0];
            int newy = col + d[1];
            island(grid, newx, newy);
        }
    }
}
