package interviewsPreparation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListNodeTest {

    @Test
    public void testReverseEmptyList() {
        // Test reversing an empty list
        ListNode listNode = new ListNode();
        ListNode reversed = listNode.reverseList(null);

        assertNull(reversed, "Reversing an empty list should return null.");
    }

    @Test
    public void testReverseSingleNodeList() {
        // Test reversing a list with a single node
        ListNode node = new ListNode(1);
        ListNode reversed = node.reverseList(node);

        assertEquals(1, reversed.val, "The value of the single node should remain the same after reversal.");
        assertNull(reversed.next, "The next node of the reversed list should be null.");
    }

    @Test
    public void testReverseMultipleNodes() {
        // Create a linked list: 1 -> 2 -> 3 -> null
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode reversed = node1.reverseList(node1);  // Expected: 3 -> 2 -> 1 -> null

        // Check the reversed list
        assertEquals(3, reversed.val, "The head of the reversed list should be 3.");
        assertEquals(2, reversed.next.val, "The second node should be 2.");
        assertEquals(1, reversed.next.next.val, "The third node should be 1.");
        assertNull(reversed.next.next.next, "The next node of the reversed list should be null.");
    }

    @Test
    public void testReverseTwoNodes() {
        // Create a linked list: 1 -> 2 -> null
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);

        ListNode reversed = node1.reverseList(node1);  // Expected: 2 -> 1 -> null

        // Check the reversed list
        assertEquals(2, reversed.val, "The head of the reversed list should be 2.");
        assertEquals(1, reversed.next.val, "The second node should be 1.");
        assertNull(reversed.next.next, "The next node of the reversed list should be null.");
    }
}
