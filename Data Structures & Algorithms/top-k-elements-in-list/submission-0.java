class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // [count, ele];
        for (int key : map.keySet()) {
            pq.add(new int[]{map.get(key), key});
        }
        System.out.println(pq.peek()[0]);
        int[] res = new int[k];
        int i = 0;
        while (i < k) {
            res[i] = pq.poll()[1];
            i ++;
        }
        return res;
    }
}
