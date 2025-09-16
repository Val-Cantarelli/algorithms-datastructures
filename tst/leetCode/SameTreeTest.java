package leetCode;

import leetCode.SameTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SameTreeTest {

    @Test
    public void testSameTreeIdentical() {
        SameTree.TreeNode node1 = new SameTree.TreeNode(1);
        SameTree.TreeNode node2 = new SameTree.TreeNode(2);
        node1.left = node2;

        SameTree.TreeNode nodeA = new SameTree.TreeNode(1);
        SameTree.TreeNode nodeB = new SameTree.TreeNode(2);
        nodeA.left = nodeB;

        assertTrue(SameTree.isSameTree(node1, nodeA), "The trees should be identical.");
    }

    @Test
    public void testSameTreeDifferentStructure() {
        SameTree.TreeNode node1 = new SameTree.TreeNode(1);
        SameTree.TreeNode node2 = new SameTree.TreeNode(2);
        node1.left = node2;

        SameTree.TreeNode nodeA = new SameTree.TreeNode(1);
        nodeA.right = node2;

        assertFalse(SameTree.isSameTree(node1, nodeA), "The trees should have different structures.");
    }

    @Test
    public void testSameTreeNull() {
        SameTree.TreeNode node1 = null;
        SameTree.TreeNode node2 = null;

        assertTrue(SameTree.isSameTree(node1, node2), "Two null trees should be considered the same.");
    }

    @Test
    public void testSameTreeOneNull() {
        SameTree.TreeNode node1 = new SameTree.TreeNode(1);
        SameTree.TreeNode node2 = null;

        assertFalse(SameTree.isSameTree(node1, node2), "One tree is null and the other is not, they should be different.");
    }

    @Test
    public void testSameTreeDifferentValues() {
        SameTree.TreeNode node1 = new SameTree.TreeNode(1);
        SameTree.TreeNode node2 = new SameTree.TreeNode(2);
        node1.left = node2;

        SameTree.TreeNode nodeA = new SameTree.TreeNode(1);
        SameTree.TreeNode nodeB = new SameTree.TreeNode(3); // Different value
        nodeA.left = nodeB;

        assertFalse(SameTree.isSameTree(node1, nodeA), "The trees should be considered different due to different values.");
    }
}
