class WordDictionary {
    class Node {
        Node[] node;
        boolean is_end;

        Node() {
            node = new Node[26];
            is_end = false;
        }
    }
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (temp.node[index] == null) {
                temp.node[index] = new Node();   
            }
            temp = temp.node[index];            
        }
        temp.is_end = true;
    }

    public boolean search(String word) {
        Node temp = root;
        return sea(word, 0, temp);
    }
    private boolean sea(String word,int index, Node temp) {
        if (index == word.length()) return temp.is_end;

        if (word.charAt(index) == '.') {
            // try all things
            for (int i = 0; i < 26; i++) {
                if (temp.node[i] != null) {
                    Node dummy = temp.node[i];
                    if (sea(word,index + 1, dummy)) return true;   
                }
            }
        } else {
            int i = word.charAt(index) - 'a';
            if (temp.node[i] == null) return false;
            Node dummy = temp.node[i];
            if (sea(word, index + 1, dummy)) return true;   
        }
        return false;
    }
}
