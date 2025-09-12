package leetCode150;

import leetCode.SameTree;
import org.junit.jupiter.api.Test;

import static leetCode.InvertBinaryTree.invertTree;
import static org.junit.jupiter.api.Assertions.*;

public class InvertBinaryTreeTest {

    @Test
    public void testInvertSimpleTree() {
        SameTree.TreeNode root = new SameTree.TreeNode(2);
        root.left = new SameTree.TreeNode(1);
        root.right = new SameTree.TreeNode(3);

        SameTree.TreeNode inverted = invertTree(root);

        assertNotNull(inverted);

        assertEquals(2, inverted.val);
        assertEquals(3, inverted.left.val);
        assertEquals(1, inverted.right.val);
    }
}
