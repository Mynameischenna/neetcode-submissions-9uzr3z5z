class PrefixTree {
    class Node {
        Node[] node;
        boolean is_end;

        Node() {
            node = new Node[26];
            is_end = false;
        }
    }

    Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (temp.node[index] == null) {
                temp.node[index] = new Node();   // ✅ fixed
            }
            temp = temp.node[index];             // ✅ fixed
        }
        temp.is_end = true;
    }

    public boolean search(String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (temp.node[index] == null) return false;  // ✅ fixed
            temp = temp.node[index];                     // ✅ fixed
        }
        return temp.is_end;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (temp.node[index] == null) return false;  // ✅ fixed
            temp = temp.node[index];                     // ✅ fixed
        }
        return true;
    }
}