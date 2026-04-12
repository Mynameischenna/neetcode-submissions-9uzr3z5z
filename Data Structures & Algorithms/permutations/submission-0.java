class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        permutation(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }
    private void permutation(int[] nums, boolean[] pickup, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!pickup[i]) {
                // add it to templist
                tempList.add(nums[i]);
                pickup[i] = true;
                permutation(nums, pickup, tempList);

                pickup[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
