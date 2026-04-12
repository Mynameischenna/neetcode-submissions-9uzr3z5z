class Solution {
    /*
    1) 0 - treasure
    2) -1 water
    3) INF -1 : water
    */
    Queue<int[]> queue = new LinkedList<>();
    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public void islandsAndTreasure(int[][] grid) {
        // multi source bfs, add all sources into the queue and then start from there
        int row = grid.length, col = grid[0].length;

        for (int i = 0;i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }
        multiSrcBfs(grid);
    }
    private void multiSrcBfs(int[][] grid) {
        
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();

            for (int dir[] : dirs) {
                int newx = loc[0] + dir[0];
                int newy = loc[1] + dir[1];
                if (newx >= 0 && newy >= 0 && newx < grid.length && newy < grid[0].length && grid[newx][newy] != -1) {
                    if (loc[2] + 1 < grid[newx][newy]) {
                        grid[newx][newy] = loc[2] + 1;
                        queue.add(new int[]{newx, newy, loc[2] + 1});
                    }
                }
            }
        }
    }
}
