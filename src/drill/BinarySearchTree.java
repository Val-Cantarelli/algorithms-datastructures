package drill;
import java.util.Iterator;
import java.util.Stack;


public class BinarySearchTree<G extends  Comparable<G>> implements Iterable<G> {
    public TreeNode root = null;


    // Client methods
    public void add(G val) {
        if (root == null) {
            root = new TreeNode(val);
        } else root.add(val);
    }

    public void printInOrder() {
        printInOrder(root);
    }

    public G findFirstLeaf() {
        return findFirstLeaf(root);
    }

    public G findLastLeaf() {
        return findLastLeaf(root);
    }

    // Class methods
    private void printInOrder(TreeNode current) {
        if (current != null) {
            printInOrder(current.left);   // Visita o filho à esquerda
            System.out.print(current.value + " ");  // Imprime o valor do nó
            printInOrder(current.right);  // Visita o filho à direita
        }
    }

    private G findFirstLeaf(TreeNode node) {
        if (node.isLeaf()) return node.value;
        if (node.left != null) return findFirstLeaf(node.left);
        return findFirstLeaf(node.right);

    }

    private G findLastLeaf(TreeNode node) {
        // iterativo
        return null;
    }

    @Override
    public Iterator<G> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<G> iteratorLeaf() {
        return new BinaryTreeIteratorLeaf();
    }

    private class BinaryTreeIteratorLeaf implements Iterator<G> {
        private Stack<TreeNode> stack = new Stack<>();

        //Construtor
        public BinaryTreeIteratorLeaf() {
            this.stack.push(root);
        }

        @Override
        public boolean hasNext() {
            return (!this.stack.isEmpty());
        }

        @Override
        public G next() {
            TreeNode node = stack.pop();
            while (hasNext()) {
                if (node.isLeaf()) return node.value;
                else {
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                }
                node = stack.pop();
            }
            return node.value;
        }

    }


    private class TreeNode {
        G value;// armazena o valor real do node
        // armazenam referencias para um node
        private TreeNode right;
        private TreeNode left;

        TreeNode(G value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        private boolean isLeaf() {
            return this.right == null && this.left == null;
        }

        private void add(G val) {
            if (val.compareTo(this.value) <= 0) {
                if (this.left == null) this.left = new TreeNode(val);
                else this.left.add(val);
            }

            if (val.compareTo(this.value) > 0) {
                if (this.right == null) this.right = new TreeNode(val);
                else this.right.add(val);
            }
        }
    }
}