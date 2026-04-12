class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]); // sort based on captial need to start the project
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < profits.length; i++) {
            minHeap.offer(new int[]{capital[i], profits[i]});
        }
        // at most do k projects
        for (int i = 0; i < k; i++) {
            while (!minHeap.isEmpty() && w >= minHeap.peek()[0]) {
                maxHeap.add(minHeap.poll()[1]);
            }

            if (maxHeap.isEmpty()) break;
            w += maxHeap.poll();
        }
        return w;
    }
}