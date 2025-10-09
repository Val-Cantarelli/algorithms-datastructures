package leetCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortedArrToBSTTest {
    @Test
    void testSortedArrayToBST() {
        SortedArrToBST converter = new SortedArrToBST();
        int[] nums = {1, 4, 7, 9, 10};
        TreeNode root = converter.sortedArrayToBST(nums);

        assertNotNull(root);
        assertEquals(7, root.val); // root should be 7
        assertNotNull(root.left);
        assertNotNull(root.right);
        assertEquals(1, root.left.val); // left child should be 1
        assertEquals(9, root.right.val); // right child should be 9
        assertEquals(4, root.left.right.val); // left-right should be 4
        assertNull(root.left.left); // left-left should be null
        assertNotNull(root.right.right); // right-right should not be null
        assertEquals(10, root.right.right.val); // right-right should be 10
        assertNull(root.right.left); // right-left should be null
    }
}

