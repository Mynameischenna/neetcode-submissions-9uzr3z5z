class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mi = nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) { // smallest element liesin right half
                left = mid + 1;
            } else right = mid;
        }
        return nums[left];
    }
}
