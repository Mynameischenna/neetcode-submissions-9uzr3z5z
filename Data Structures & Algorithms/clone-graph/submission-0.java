/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
        newNode.neighbors = new ArrayList<Node>();

        for (Node neighbor : node.neighbors) {
            if (map.containsKey(neighbor.val)) {
                newNode.neighbors.add(map.get(neighbor.val));
            } else {
                newNode.neighbors.add(cloneGraph(neighbor)); 
            } 
               
        }
        return newNode;
    }
}