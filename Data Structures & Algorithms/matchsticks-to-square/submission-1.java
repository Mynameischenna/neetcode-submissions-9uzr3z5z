class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = Arrays.stream(matchsticks).sum();
        if (total % 4 != 0) return false;

        Arrays.sort(matchsticks);
        reverse(matchsticks);

        return dfs(matchsticks, 0, new int[4], total / 4);
    }

    private boolean dfs(int[] sticks, int index, int[] sides, int target) {
        if (index == sticks.length) {
            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + sticks[index] <= target) {
                sides[i] += sticks[index];

                if (dfs(sticks, index + 1, sides, target)) return true;

                sides[i] -= sticks[index]; // backtrack
            }
        }

        return false;
    }

    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
}