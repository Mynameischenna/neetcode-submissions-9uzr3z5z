class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        // make adj list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        if (!dfs(0, -1, adj, visited)) return false;

        return visited.size() == n;

    }
    private boolean dfs(int node, int parent, List<List<Integer>> adj, Set<Integer> visited) {
        if (visited.contains(node)) return false;
        visited.add(node);
        // traverse all nodes
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) continue;
            if (!dfs(neighbor, node, adj, visited)) return false;
        }
        return true;
    }
    
}
