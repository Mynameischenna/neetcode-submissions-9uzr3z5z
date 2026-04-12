class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int carFleets = 0, n = speed.length;
        int[][] sortA = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortA[i][0] = position[i];
            sortA[i][1] = speed[i];
        }
        Arrays.sort(sortA, (a, b) -> a[0] - b[0]);
        Stack<Double> stack = new Stack<>(); // mono dec stack
        for (int i = n - 1; i >= 0; i--) {
            // find the time it takes to reach the destination
            double time = (target - sortA[i][0]) / (double)sortA[i][1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
                carFleets ++;
            }
        }
        return carFleets;
    }
}
