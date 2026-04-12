class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] res = new int[n];
        // add the original index[enqueueTime, processingTime, originalIndex]
        for (int i = 0; i < n; i++) {
            tasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        // sort based on start time
        Arrays.sort(tasks, (a, b) -> a[0] - b[0]);
        // sort based on low processing time from available tasks
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[2] - b[2];
            return a[1] - b[1];
        }); 
        int time = 0, index = 0, resIndex = 0;
        while (index < n || !pq.isEmpty()) {
            if (index < n)
                time = Math.max(time, tasks[index][0]);
            // current avaiable tasks at this time, find the low processing from ther avaibale tasks
            while (index < n && time >= tasks[index][0]) {
                pq.add(tasks[index ++]);
            }
            int[] currTask = pq.poll();
            res[resIndex ++] = currTask[2];
            time = time + currTask[1];
        }
        return res;

    }
}