class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // window size should be abs(i - j <= k) --> k + 1
        int index = 0, n = nums.length;
        while (index < Math.min(k + 1, n)) {
            if (map.containsKey(nums[index])) return true;
            else map.put(nums[index], 0);
            index ++;
        }
        int left = 0;
        while (index < n) {
            // remove left one
            map.remove(nums[left ++]);
            if (map.containsKey(nums[index])) return true;
            else map.put(nums[index], 0);
            index ++;
        }
        return false;
    }
}