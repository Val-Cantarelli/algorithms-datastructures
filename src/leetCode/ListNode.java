package leetCode;

//Definition for singly-linked list.Tag: easy
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public ListNode() {}
    public ListNode(int val) { this.val = val; }


    public ListNode reverseList(ListNode head) {
        /*
        I just update the references of each node to point
        to the previous one and return a new head.
        */
        ListNode previous = null;
        ListNode current = head;

        //Iterate through the list until the end
        while(current != null){
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous; //new head
    }
}
