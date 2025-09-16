package leetCode;

import leetCode.PathSum;
import leetCode.SameTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PathSumTest {

    @Test
    public void testPathExists() {
        //     5
        //    / \
        //   4   8
        //  /   / \
        // 11  13  4
        // / \
        //7   2
        SameTree.TreeNode root = new SameTree.TreeNode(5,
                new SameTree.TreeNode(4,
                        new SameTree.TreeNode(11, new SameTree.TreeNode(7), new SameTree.TreeNode(2)),
                        null
                ),
                new SameTree.TreeNode(8,
                        new SameTree.TreeNode(13),
                        new SameTree.TreeNode(4)
                )
        );

        boolean result = new PathSum().hasPathSum(root, 22);
        assertTrue(result);
    }

    @Test
    public void testNoValidPath() {
        // Mesmo exemplo, mas soma impossível
        SameTree.TreeNode root = new SameTree.TreeNode(5,
                new SameTree.TreeNode(4,
                        new SameTree.TreeNode(11, new SameTree.TreeNode(7), new SameTree.TreeNode(2)),
                        null
                ),
                new SameTree.TreeNode(8,
                        new SameTree.TreeNode(13),
                        new SameTree.TreeNode(4)
                )
        );

        boolean result = new PathSum().hasPathSum(root, 100);
        assertFalse(result);
    }

    @Test
    public void testEmptyTree() {
        boolean result = new PathSum().hasPathSum(null, 0);
        assertFalse(result);
    }

    @Test
    public void testSingleNodeEqualsTarget() {
        SameTree.TreeNode root = new SameTree.TreeNode(7);
        boolean result = new PathSum().hasPathSum(root, 7);
        assertTrue(result);
    }

    @Test
    public void testSingleNodeNotEqualsTarget() {
        SameTree.TreeNode root = new SameTree.TreeNode(1);
        boolean result = new PathSum().hasPathSum(root, 2);
        assertFalse(result);
    }
}
