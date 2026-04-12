
class Node {
    int data;
    int key;
    Node prev;
    Node next;

    Node(int data, int key) {
        this.data = data;
        this.key = key;
    }
}

class LRUCache {

    int capacity, size;
    Map<Integer, Node> map;
    Node head, tail; // dummy nodes

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();

        head = new Node(0, 0); // dummy head
        tail = new Node(0, 0); // dummy tail

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insertAtFront(node);

        return node.data;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.data = value;

            remove(node);
            insertAtFront(node);
        } else {

            if (size == capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
                size--;
            }

            Node newNode = new Node(value, key);
            insertAtFront(newNode);
            map.put(key, newNode);
            size++;
        }
    }

    // remove any node
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // always insert right after dummy head
    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}