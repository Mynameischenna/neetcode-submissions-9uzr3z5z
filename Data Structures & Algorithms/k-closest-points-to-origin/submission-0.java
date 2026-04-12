class Point {
    int x;
    int y;
    Point(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
// association - class relation ship
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Double, Stack<Point>> map = new HashMap<>();
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        for (int[]point : points) {
            int x1 = point[0];
            int y1 = point[1];
            double res = Math.sqrt(x1 * x1 + y1 * y1);
            if (!map.containsKey(res)) {
                map.put(res, new Stack<>());
            }
            map.get(res).push(new Point(x1, y1));
            pq.add(res);
            if (pq.size() > k) pq.poll();
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while (k --> 0) {
            double dis = pq.poll();
            Point p = map.get(dis).pop();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
            i ++;
            if (map.get(dis) == null) map.remove(dis);
        }
        return ans;

    }
}
