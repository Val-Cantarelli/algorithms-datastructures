package leetCode150;

import java.util.HashSet;
import java.util.Set;

//EASY
public class ListNode {
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next = node2;


        System.out.println(hasCycle(node1));
    }
    public static boolean hasCycle(ListNode head) {
        if(head == null) return false;
        Set<ListNode> set = new HashSet<>();


        ListNode curent = head;
        set.add(curent);
        while (curent.next != null){
            if(set.contains(curent))return true;
            set.add(curent);
            curent = curent.next;
        }


        return true;
    }
}
