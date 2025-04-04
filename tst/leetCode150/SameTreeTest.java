package leetCode150;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SameTreeTest {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    @Test
    public void testSameTreeIdentical() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;

        TreeNode nodeA = new TreeNode(1);
        TreeNode nodeB = new TreeNode(2);
        nodeA.left = nodeB;

        assertTrue(isSameTree(node1, nodeA), "The trees should be identical.");
    }

    @Test
    public void testSameTreeDifferentStructure() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;

        TreeNode nodeA = new TreeNode(1);
        nodeA.right = node2; // Different structure

        assertFalse(isSameTree(node1, nodeA), "The trees should have different structures.");
    }

    @Test
    public void testSameTreeNull() {
        TreeNode node1 = null;
        TreeNode node2 = null;

        assertTrue(isSameTree(node1, node2), "Two null trees should be considered the same.");
    }

    @Test
    public void testSameTreeOneNull() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = null;

        assertFalse(isSameTree(node1, node2), "One tree is null and the other is not, they should be different.");
    }

    @Test
    public void testSameTreeDifferentValues() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;

        TreeNode nodeA = new TreeNode(1);
        TreeNode nodeB = new TreeNode(3); // Different value
        nodeA.left = nodeB;

        assertFalse(isSameTree(node1, nodeA), "The trees should be considered different due to different values.");
    }
}
