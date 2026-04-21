class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // make adj list
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            indegree[p[0]] ++;
            list.get(p[1]).add(p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                // no of inc nodes is 0 , no depedency
                queue.add(i);
            }
        }
        int processedNodes = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            processedNodes ++;
            // for all neighbours reduce its indegeree by 1
            for (int neighbor : list.get(node)) {
                indegree[neighbor] --;
                if (indegree[neighbor] == 0) queue.add(neighbor);
            }
        }
        return processedNodes == numCourses;
    }
}
