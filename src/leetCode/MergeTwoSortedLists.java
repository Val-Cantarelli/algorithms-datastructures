package leetCode;

public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //  storeHedInformation is a dummy node, but it will store the most relevant information: head
        ListNode storeHedInformation = new ListNode(-1);
        ListNode current = storeHedInformation;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            }
            else{
               current.next = list2;
               list2 = list2.next;
            }
            current = current.next;
        }

        //
        if(list1 != null){
            current.next = list1;
        }else{
            current.next = list2;
        }

        return storeHedInformation.next;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);


        node1.next=node2;
        node2.next=node3;
        node3.next=null;


        ListNode nodeA = new ListNode(3);
        ListNode nodeB= new ListNode(4);
        ListNode nodeC = new ListNode(5);


        nodeA.next=nodeB;
        nodeB.next=nodeC;
        nodeC.next=null;


        ListNode currentNode = mergeTwoLists(node1,nodeA);

        while (currentNode != null){
            System.out.print(currentNode.val+ " ");
            currentNode = currentNode.next;
        }

    }
}
