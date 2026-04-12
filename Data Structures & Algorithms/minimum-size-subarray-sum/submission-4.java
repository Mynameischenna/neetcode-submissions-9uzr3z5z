class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        // prefix sum
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        if (nums[0] >= target) return 1;
        
        for (int i = 1; i < n; i++) {
            preSum[i] += nums[i] + preSum[i - 1];
        }
        if (preSum[n - 1] == target) return n;
        
        int left = 0, len = Integer.MAX_VALUE;
        for (int right = 0; right < n; right ++){
            if (preSum[right] >= target) {
                // try to reduce from left
                while (left < right && preSum[right] - preSum[left] >= target) {
                    len = Math.min(len, right - left);
                    left ++;
                }
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}