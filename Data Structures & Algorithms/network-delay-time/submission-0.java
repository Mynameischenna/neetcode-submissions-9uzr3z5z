class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {

        int[] time = new int[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);

        // Build graph
        List<List<int[]>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int dis = t[2];

            list.get(u).add(new int[]{v, dis});
        }

        // Dijkstra
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        time[k] = 0;
        pq.add(new int[]{k, 0}); // node, totalDistance

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int u = curr[0];
            int di = curr[1];

            // Skip stale entries
            if (di > time[u]) {
                continue;
            }

            for (int[] neighbor : list.get(u)) {

                int nei = neighbor[0];
                int dis = neighbor[1];

                // Relaxation
                if (di + dis < time[nei]) {

                    time[nei] = di + dis;

                    pq.add(new int[]{nei, time[nei]});
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {

            if (time[i] == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, time[i]);
        }

        return max;
    }
}