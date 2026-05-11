class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // build a directed graph, using adj list
        List<List<Integer>> graph = new ArrayList<>(); // node : list of neighbors
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // build the indegree in the mean time
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            int u = p[0];
            int v = p[1];
            // u -> v
            graph.get(u).add(v);
            indegree[v] ++;
        }
        Queue<Integer> q = new LinkedList<>();

        // to keep track of set of all depe nodes for this node
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // add all courses who has no depe
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
            if (indegree[i] == 0) {
                q.add(i);
                map.put(i, new HashSet<>());
            }
        }
        

        // lets process
        while (!q.isEmpty()) {
            // get the node

            int node = q.poll();

            // get the neighbors
            for (int neighbor : graph.get(node)) {
                // add it to the depe set
                // u -> v == > map.put(v, u); // and list of parent depe
                // map.put(v, map.get(v).add(map.get(u)));
                map.get(neighbor).add(node);
                map.get(neighbor).addAll(map.get(node));
                // reduce the indegree since parent is completed
                indegree[neighbor] --;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int qu[] : queries) {
            int u = qu[0];
            int v = qu[1];

            // is u is depe of v
            // get the set of v and checking is u prenet in ther or not
            res.add(map.get(v).contains(u));
        }
        return res;

    }
}