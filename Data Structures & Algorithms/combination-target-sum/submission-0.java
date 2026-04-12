class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combination(nums, target, 0, new ArrayList<>());
        return res;
    }
    private void combination(int[] nums, int target, int index, List<Integer> list) {
        if (index == nums.length || target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        combination(nums, target - nums[index], index, list);
        list.remove(list.size() - 1);
        combination(nums, target, index + 1, list);
    }
}
