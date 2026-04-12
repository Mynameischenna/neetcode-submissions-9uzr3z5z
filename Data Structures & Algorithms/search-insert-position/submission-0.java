class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int min = 0, max = n - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) max = mid - 1;
            else min = mid + 1;
        }
        return min;
    }
}