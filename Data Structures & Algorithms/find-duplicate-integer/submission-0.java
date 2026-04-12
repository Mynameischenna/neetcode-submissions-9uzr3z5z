class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;// numbers will be from [1, n - 1] n = 5, arr will be [1, 4]
        // negative marking
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]);
            if (nums[idx] < 0) return idx; // if it already marked as negative means visited
            nums[idx] = -nums[idx];
        }
        return -1;
    }
}
