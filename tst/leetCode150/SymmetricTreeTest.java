package leetCode150;

import leetCode.SameTree;
import leetCode.SymmetricTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SymmetricTreeTest {

    @Test
    public void testSymmetricTreeDepth2() {
        //     1
        //    / \
        //   2   2
        //  / \ / \
        // 3  4 4  3
        SameTree.TreeNode root = new SameTree.TreeNode(1,
                new SameTree.TreeNode(2, new SameTree.TreeNode(3), new SameTree.TreeNode(4)),
                new SameTree.TreeNode(2, new SameTree.TreeNode(4), new SameTree.TreeNode(3))
        );

        SymmetricTree sym = new SymmetricTree();
        boolean result = sym.isSymmetric(root);
        assertTrue(result);
    }

    @Test
    public void testAsymmetricTreeDepth2() {
        //     1
        //    / \
        //   2   2
        //    \   \
        //    3    3
        SameTree.TreeNode root = new SameTree.TreeNode(1,
                new SameTree.TreeNode(2, null, new SameTree.TreeNode(3)),
                new SameTree.TreeNode(2, null, new SameTree.TreeNode(3))
        );

        SymmetricTree sym = new SymmetricTree();
        boolean result = sym.isSymmetric(root);
        assertFalse(result);
    }

    @Test
    public void testSingleNode() {
        //     1
        SameTree.TreeNode root = new SameTree.TreeNode(1);

        SymmetricTree sym = new SymmetricTree();
        boolean result = sym.isSymmetric(root);
        assertTrue(result);
    }

    @Test
    public void testNullTree() {
        SameTree.TreeNode root = null;

        SymmetricTree sym = new SymmetricTree();
        boolean result = sym.isSymmetric(root);
        assertTrue(result);
    }
}
