class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();

        // mono inc stack
        for (int i = n - 1; i >= 0; i--) {
            int dayTemp = t[i];
            while (!stack.isEmpty() && stack.peek()[0] <= dayTemp) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek()[1] - i;
            } else res[i] = 0;

            stack.push(new int[]{t[i], i});
        }
        return res;
    }
}
