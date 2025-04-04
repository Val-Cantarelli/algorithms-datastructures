package leetCode150;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MaxDepthTreeTest {

    @Test
    public void testMaxDepthTree() {
        MaxDepthTree.TreeNode node1 = new MaxDepthTree.TreeNode(3);
        MaxDepthTree.TreeNode node2 = new MaxDepthTree.TreeNode(9);
        MaxDepthTree.TreeNode node3 = new MaxDepthTree.TreeNode(20);
        MaxDepthTree.TreeNode node4 = new MaxDepthTree.TreeNode(15);
        MaxDepthTree.TreeNode node5 = new MaxDepthTree.TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        int result = MaxDepthTree.maxDepthTree(node1);
        assertEquals(3, result); // altura máxima esperada
    }

    @Test
    public void testSingleNode() {
        MaxDepthTree.TreeNode root = new MaxDepthTree.TreeNode(1);
        assertEquals(1, MaxDepthTree.maxDepthTree(root));
    }

    @Test
    public void testNullTree() {
        assertEquals(0, MaxDepthTree.maxDepthTree(null));
    }
}
