class Solution {
    public int subsetXORSum(int[] nums) {
        return subset(nums, 0, 0);
    }
    private int subset(int[] nums, int index, int currXor) {
        if (index == nums.length) {
            return currXor;
        }

        int include = subset(nums, index + 1, currXor ^ nums[index]);
        int exclude = subset(nums, index + 1, currXor);

        return include + exclude;

    }
}