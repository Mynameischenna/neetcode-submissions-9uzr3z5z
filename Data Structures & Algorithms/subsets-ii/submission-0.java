class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subset(nums, 0, new ArrayList<>());
        return res;
    }
    private void subset(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        // take it
        list.add(nums[index]);
        subset(nums, index + 1, list);

        // not take it
        list.remove(list.size() - 1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index ++;
        }
        subset(nums, index + 1, list);
    }
}
