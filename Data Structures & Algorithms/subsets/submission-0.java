class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subset(nums, 0, new ArrayList<>());
        return res;
    }
    private void subset(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList(list));
            return;
        }
        // take it
        list.add(nums[index]);
        subset(nums, index + 1, list);

        // leave it
        list.remove(list.size() - 1);
        subset(nums, index + 1, list);
        
    }
}
