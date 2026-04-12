class Solution {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            if (asteroid > 0) {
                stack.push(asteroid);
            } 
            else {

                while (!stack.isEmpty() && stack.peek() > 0) {

                    if (stack.peek() < -asteroid) {
                        stack.pop();
                        continue;
                    }

                    if (stack.peek() == -asteroid) {
                        stack.pop();
                    }

                    asteroid = 0;
                    break;
                }

                if (asteroid != 0) {
                    stack.push(asteroid);
                }
            }
        }

        int n = stack.size();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}