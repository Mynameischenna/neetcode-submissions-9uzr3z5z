class Solution {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        int mi = nums[0];
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[l] <= nums[mid]) { // left half is sorted
                mi = Math.min(mi, nums[l]);
                l = mid + 1;
            } else { // right is sorted
                mi = Math.min(mi, nums[mid]);
                h = mid - 1;
            }
        }
        return mi;
    }
}
