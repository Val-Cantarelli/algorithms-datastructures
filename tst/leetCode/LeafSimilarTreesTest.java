package leetCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeafSimilarTreesTest {

    @Test
    public void testSimilarLeafTrees() {
        // Create two identical trees with the same leaf sequences
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);  // Leaves: 4, 5, 3

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);  // Leaves: 4, 5, 3

        LeafSimilarTrees leafSimilarTrees = new LeafSimilarTrees();
        assertTrue(leafSimilarTrees.leafSimilar(root1, root2),
                "The leaf sequences should be similar");
    }

    @Test
    public void testDifferentLeafTrees() {
        // Create two trees with different leaf sequences
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);  // Leaves: 4, 3

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(4);
        root2.left.left = new TreeNode(3);  // Leaves: 4, 3

        LeafSimilarTrees leafSimilarTrees = new LeafSimilarTrees();
        assertFalse(leafSimilarTrees.leafSimilar(root1, root2),
                "The leaf sequences should be different");
    }

    @Test
    public void testOneTreeEmpty() {
        // Create one empty tree and one non-empty tree
        TreeNode root1 = null;  // Empty tree

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);  // Leaves: 4, 3

        LeafSimilarTrees leafSimilarTrees = new LeafSimilarTrees();
        assertFalse(leafSimilarTrees.leafSimilar(root1, root2),
                "An empty tree cannot have the same leaves as a non-empty tree");
    }

    @Test
    public void testBothTreesEmpty() {
        // Test when both trees are empty
        TreeNode root1 = null;
        TreeNode root2 = null;

        LeafSimilarTrees leafSimilarTrees = new LeafSimilarTrees();
        assertTrue(leafSimilarTrees.leafSimilar(root1, root2),
                "Both empty trees should have similar leaf sequences");
    }

    @Test
    public void testSingleLeafTrees() {
        // Test with trees that have only one leaf
        TreeNode root1 = new TreeNode(1);  // Single leaf 1
        TreeNode root2 = new TreeNode(1);  // Single leaf 1

        LeafSimilarTrees leafSimilarTrees = new LeafSimilarTrees();
        assertTrue(leafSimilarTrees.leafSimilar(root1, root2),
                "Single-node trees with the same value should have similar leaf sequences");

        TreeNode root3 = new TreeNode(2);  // Single leaf 2
        assertFalse(leafSimilarTrees.leafSimilar(root1, root3),
                "Single-node trees with different values should not have similar leaf sequences");
    }
}
