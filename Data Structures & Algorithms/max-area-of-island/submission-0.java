class Solution {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, maxIsland(grid, i, j, visited));
                }
            }
        }
        return maxArea;
    }
    private int maxIsland(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 0 || visited[row][col]) 
            return 0;
        int area = 1;
        visited[row][col] = true;
        for (int[] dir : dirs) {
            int newx = row + dir[0];
            int newy = col + dir[1];

            area += maxIsland(grid, newx, newy, visited);
        }
        return area;
    }
}
