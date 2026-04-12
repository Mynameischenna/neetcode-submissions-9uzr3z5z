class Solution {

    int[][] dp;
    int[] prefix;

    public int splitArray(int[] nums, int k) {

        int n = nums.length;

        prefix = new int[n + 1];
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + nums[i];

        dp = new int[n][k + 1];

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        return solve(nums, 0, k);
    }

    private int solve(int[] nums, int index, int k) {

        int n = nums.length;

        if (k == 1)
            return prefix[n] - prefix[index];

        if (dp[index][k] != -1)
            return dp[index][k];

        int minMax = Integer.MAX_VALUE;

        for (int i = index; i <= n - k; i++) {

            int left = prefix[i + 1] - prefix[index];

            int right = solve(nums, i + 1, k - 1);

            int largest = Math.max(left, right);

            minMax = Math.min(minMax, largest);
        }

        return dp[index][k] = minMax;
    }
}