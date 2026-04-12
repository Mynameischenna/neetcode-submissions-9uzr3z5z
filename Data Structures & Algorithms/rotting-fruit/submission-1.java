class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int row = grid.length, col = grid[0].length;

        // Step 1: count fresh & add rotten to queue
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Step 2: BFS
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];

                for (int[] d : dirs) {
                    int nx = x + d[0];
                    int ny = y + d[1];

                    if (nx >= 0 && ny >= 0 && nx < row && ny < col && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;   // 🔥 mark rotten
                        q.add(new int[]{nx, ny});
                        fresh--;
                    }
                }
            }

            time++; // only when spread happens
        }

        return fresh == 0 ? time : -1;
    }
}