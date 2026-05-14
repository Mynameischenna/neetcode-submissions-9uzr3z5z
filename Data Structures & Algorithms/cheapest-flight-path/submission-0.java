class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // k means level
        int level = 0;
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // build graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];

            graph.get(u).add(new int[]{v, wt});
        }

        // process airports at level wise
        Queue<int[]> q = new LinkedList<>();
        dist[src] = 0;
        q.add(new int[]{src, dist[src]}); // node, dist

        while (!q.isEmpty() && level <= k) {
            
            int size = q.size();
            for (int i = 0;i < size; i++) {
                int[] node = q.poll();
                int u = node[0];
                int dis = node[1];
                // check all its neighbors
                for (int[] neighbor : graph.get(u)) {
                    int v = neighbor[0];
                    int wt = neighbor[1];

                    if (dis + wt < dist[v]) {
                        dist[v] = dis + wt;
                        q.add(new int[]{v, dist[v]});
                    }
                }
            }
            level ++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1  : dist[dst];
    }
}
