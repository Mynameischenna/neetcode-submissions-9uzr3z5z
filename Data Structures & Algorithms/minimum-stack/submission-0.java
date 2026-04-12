class MinStack {
    class Node {
        int data;
        int min;
        Node next;
        public Node(int data) {
            this.data = data;
            this.min = data;
            this.next = null;
        }
    }
    Node head;
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        Node node = new Node(val);
        if (head != null) {
            node.min = Math.min(node.min, head.min);
        }
        node.next = head;
        head = node;
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return head.min;
    }
}
