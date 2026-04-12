class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // max heap
        for (int stone : stones) pq.add(stone);
        while (!pq.isEmpty()) {
            if (pq.size() == 1) return pq.poll();
            else {
                int ele1 = pq.poll();
                int ele2 = pq.poll();

                if (ele1 < ele2) {
                    pq.add(ele2 - ele1);
                } else if (ele2 < ele1) {
                    pq.add(ele1 - ele2);
                }
            }
        }
        return 0;
    }
}
