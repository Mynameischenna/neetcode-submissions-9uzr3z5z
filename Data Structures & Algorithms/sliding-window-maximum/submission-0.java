class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

       List<Integer> list = new ArrayList<>();
       for (int i = 0; i < k; i++) {
            if (!map.containsKey(nums[i])) pq.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
       }
       list.add(pq.peek());
       int left = 0;
       for (int i = k ; i < nums.length; i++) {
            // remove from left
            map.put(nums[left], map.get(nums[left]) - 1);
            if (map.get(nums[left]) == 0) {
                map.remove(nums[left]); // remove from map
                pq.remove(nums[left]); // remove from pq
            }
            left ++;
            // add
            if (!map.containsKey(nums[i])) pq.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            list.add(pq.peek());
       }
        int[] res = new int[list.size()];
       for (int i = 0; i < list.size(); i++) {
        res[i] = list.get(i);
       }
       return res;
    }
}
