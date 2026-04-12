class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList();
        int i = 0;
        Arrays.sort(nums);
        while (i < n) {
            while (i < n && i > 0 && nums[i] == nums[i - 1]) i ++;
            int l = i + 1, r = n - 1;

            while (l < r) {
                if (nums[l] + nums[r] + nums[i] == 0) {
                    list.add(List.of(nums[i], nums[l], nums[r]));
                    l ++;
                    r --;
                    while (l < n && nums[l] == nums[l - 1]) l ++;
                    while (r >= 0 && nums[r] == nums[r + 1]) r--;
                } else if (nums[l] + nums[r] + nums[i] > 0) {
                    r --;
                } else l ++;
            }
            i ++;
        }
        return list;
    }
}
