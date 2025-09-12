package leetCode;
import java.util.Iterator;
import java.util.Stack;
/*
* Consider all the leaves of a binary tree, from left to
* right order, the values of those leaves form a leaf value
* sequence.
* */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        Iterator<Integer> iter1 = new TreeNodeIterator(root1);
        Iterator<Integer> iter2 = new TreeNodeIterator(root2);
        while(iter1.hasNext() && iter2.hasNext()) {
            if (!iter1.next().equals(iter2.next())) return false;
        }
        // Verificar se ambos terminaram ao mesmo tempo
        return !iter1.hasNext() && !iter2.hasNext();
    }
    // Internal structure
    private class TreeNodeIterator implements Iterator<Integer> {
        private Stack<TreeNode> stack = new Stack<>();

        public TreeNodeIterator (TreeNode node) {
            stack.push(node);
        }

        public boolean hasNext(){
            return !stack.empty();
        }
        private boolean isLeaf(TreeNode node){
            return (node.right==null && node.left == null);
        }

        public Integer next(){
            TreeNode node = stack.pop();

            while (!isLeaf(node)){
                // enquanto não folha: push right e left no stack e atualiza node
                // testar e inverter
                if(node.left != null)stack.push(node.left);
                if(node.right != null)stack.push(node.right);
                node = stack.pop();
            }
            return node.val;
        }
    }
}