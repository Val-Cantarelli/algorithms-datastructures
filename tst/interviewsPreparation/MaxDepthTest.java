package interviewsPreparation;
import leetCode.MaxDepth;
import leetCode.TreeNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaxDepthTest {

    MaxDepth maxDepth = new MaxDepth();

    // (root == null)
    @Test
    public void testNullTree() {
        TreeNode root = null;
        int result = maxDepth.maxDepth(root);
        assertEquals(0, result, "A árvore nula deve ter profundidade 0");
    }

    // 1 node
    @Test
    public void testSingleNodeTree() {
        TreeNode root = new TreeNode(1); // Árvore: 1
        int result = maxDepth.maxDepth(root);
        assertEquals(1, result, "Uma árvore com apenas um nó deve ter profundidade 1");
    }
    //Unbalanced tree
    @Test
    public void testTreeWithMultipleLevels() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);

        /*
            Árvore:
                    1
                   / \
                  2   3
                 / \
                4   5
               /
              6
        */
        int result = maxDepth.maxDepth(root);
        assertEquals(4, result, "MaxDepth: 4");
    }

    // Balanced tree
    @Test
    public void testBalancedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        /*
            Árvore:
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7
        */
        int result = maxDepth.maxDepth(root);
        assertEquals(3, result, "MaxDepth: 3");
    }

    // Unbalanced tree
    @Test
    public void testRightSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        /*
            Árvore:
            1
             \
              2
               \
                3
                 \
                  4
        */
        int result = maxDepth.maxDepth(root);
        assertEquals(4, result, "MaxDepth: 4");
    }
}
