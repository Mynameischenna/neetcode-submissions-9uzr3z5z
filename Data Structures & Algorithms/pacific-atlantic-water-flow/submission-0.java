class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int row, col;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        row = heights.length;
        col = heights[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        // Pacific (top + left)
        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, pacific);
            dfs(heights, i, col - 1, atlantic);
        }

        for (int j = 0; j < col; j++) {
            dfs(heights, 0, j, pacific);
            dfs(heights, row - 1, j, atlantic);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr >= row || nc >= col) continue;

            if (visited[nr][nc]) continue;

            // 🔥 reverse flow condition
            if (heights[nr][nc] < heights[r][c]) continue;

            dfs(heights, nr, nc, visited);
        }
    }
}