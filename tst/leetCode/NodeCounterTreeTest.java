package leetCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NodeCounterTreeTest {
    @Test
    void testCountNodes_CompleteTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        NodeCounterTree counter = new NodeCounterTree();
        assertEquals(6, counter.countNodes(root));
    }

    @Test
    void testCountNodes_EmptyTree() {
        NodeCounterTree counter = new NodeCounterTree();
        assertEquals(0, counter.countNodes(null));
    }

    @Test
    void testCountNodes_SingleNode() {
        TreeNode root = new TreeNode(1);
        NodeCounterTree counter = new NodeCounterTree();
        assertEquals(1, counter.countNodes(root));
    }
}

