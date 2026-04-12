class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int islandPerimeter(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return island(grid, i, j, new boolean[row][col]);
                }
            }
        }
        return 0;
    }
    private int island(int[][] grid, int row,int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 0) {
            return 1;
        }
        if (visited[row][col]) return 0;

        visited[row][col] = true;
        int perimeter = 0;
        for (int[] dir : dirs) {
            int newx = dir[0] + row;
            int newy = dir[1] + col;
            perimeter += island(grid, newx, newy, visited);
        }
        return perimeter;
    }
}