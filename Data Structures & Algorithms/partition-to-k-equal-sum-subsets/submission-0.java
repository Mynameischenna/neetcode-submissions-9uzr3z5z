class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % k != 0) return false;
        Arrays.sort(nums);
        reverse(nums);
        int length = totalSum / k;
        return partition(nums, k, 0, new int[k], length);
    }
    private boolean partition(int[] nums, int k, int index, int[] boxes, int target) {
        if (index == nums.length) {
            for (int i = 0; i < k; i++) {
                if (boxes[i] != target) return false;
            }
            return true;
        }

        for (int i = 0; i < k; i++) {
            if (boxes[i] + nums[index] <= target) {
                boxes[i] += nums[index];
                if (partition(nums, k, index + 1, boxes, target)) return true;
                boxes[i] -= nums[index];
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