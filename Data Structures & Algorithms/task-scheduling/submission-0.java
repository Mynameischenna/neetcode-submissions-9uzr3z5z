
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<int[]> q = new LinkedList<>(); // taskCount, nextavailTime
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int[] temp = new int[26];
        for (char c : tasks) {
            temp[c - 'A'] ++;
        }
        for (int c : temp) {
            if (c > 0) pq.add(c); // tasks thats it
        }
        int totalTime = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            if (pq.isEmpty()) {
                totalTime = q.peek()[1];
            }
            totalTime ++;
            while (!q.isEmpty() && totalTime > q.peek()[1]) {
                pq.add(q.poll()[0]);
            }
            int cnt = pq.poll() - 1;
            if (cnt > 0) q.add(new int[]{cnt, totalTime + n}); // this task will be available at aftet this time
               
        }
        return totalTime;
    }
}
