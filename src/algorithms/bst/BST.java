package algorithms.bst;

public class BST <Key extends  Comparable<Key>,Value>{

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        Node right, left;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(Key key, Value value) {

        root = put(root,key,value);
    }
    private Node put(Node root, Key key, Value value) {

        if(root == null) new Node(key,value);
        int comparation = key.compareTo(root.key);
        if (comparation < 0) put(root.left,key,value);
        else if (comparation > 0) put(root.right,key,value);
        else root.val = value;

        return root;

    }

    public Value get(Key key) {
        Node x = root;

        while(x != null){
            int comparation = key.compareTo(x.key);
            if(comparation < 0) x = x.left;
            else if (comparation > 0) {
                x = x.right;
            }
            else return x.val;
        }
        return null;
    }

    public void delete(Key key) {}

    public Iterable<Key> iterator() {return null;}

}
