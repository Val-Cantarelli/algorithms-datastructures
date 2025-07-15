package leetCode150;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MinAbsoluteDiffBSTTest {

    @Test
    public void testMinDiff() {
        // Montando a árvore [4,2,6,1,3]
        SameTree.TreeNode root = new SameTree.TreeNode(4);
        root.left = new SameTree.TreeNode(2);
        root.right = new SameTree.TreeNode(6);
        root.left.left = new SameTree.TreeNode(1);
        root.left.right = new SameTree.TreeNode(3);

        MinAbsoluteDiffBST solver = new MinAbsoluteDiffBST();
        int result = solver.getMinimumDifference(root);

        assertEquals(1, result);
    }
}
