class FreqStack {
    private int index;
    private Map<Integer, Integer> map;
    private PriorityQueue<int[]> pq; // [value, count, index]
    public FreqStack() {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (b[1] != a[1]) return b[1] - a[1]; // if not tie
            else return b[2] - a[2]; // return max index
        });
        index = 0;    
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        pq.add(new int[]{val, map.get(val), index ++});
    }
    
    public int pop() {
        int[] head = pq.poll();
        map.put(head[0], map.get(head[0]) - 1);
        return head[0];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */