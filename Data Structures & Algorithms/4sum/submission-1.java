class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList();
        int p1 = 0, n = nums.length;
        Arrays.sort(nums);
        while (p1 < n) {
            int p2 = p1 + 1;
            while (p2 < n) {
                int l = p2 + 1, r = n - 1; 
                while (l < r) {
                    long sum = (long) nums[p1] + nums[p2] + nums[l] + nums[r];
                    if (sum == target) {
                        list.add(List.of(nums[p1], nums[p2], nums[l], nums[r]));
                        l ++;
                        r --;
                        while (l < n && nums[l] == nums[l - 1]) l ++;
                        while (r >= 0 && nums[r] == nums[r + 1]) r --;
                    } else if (sum > target) r --;
                    else l ++;    
                }
                p2 ++;
                while (p2 < n && nums[p2] == nums[p2 - 1]) p2 ++;
            }
            p1 ++;
            while (p1 < n && nums[p1] == nums[p1 - 1]) p1 ++;
        }
        return list;
    }
}