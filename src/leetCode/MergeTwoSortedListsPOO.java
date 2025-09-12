package leetCode;

public class MergeTwoSortedListsPOO {

    // Represents the nodes of a "list"
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
    // Represents a linkedList
    public static class ListVal {
        private ListNode head;
        private ListNode tail;


        void add(ListNode node){
            if (head == null){
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = node;
            }
        }
    }

    // Iterator through the linkedList
    public static class ValIterator {
        private ListNode current;

        public ValIterator(ListNode listNode) {
            this.current = listNode;
        }

        boolean hasNext(){
            return current != null;
        }
        ListNode next(){
            ListNode ant = current;
            current = current.next;
            return ant;
        }
    }
    // a method which performs the merge
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListVal list3 = new ListVal();
        ValIterator iteratorList1 = new ValIterator(list1);
        ValIterator iteratorList2 = new ValIterator(list2);

        while(iteratorList1.hasNext() && iteratorList2.hasNext()){
            // val

            if(iteratorList1.current.val <= iteratorList2.current.val) {
                list3.add(iteratorList1.next());
            } else {
                list3.add(iteratorList2.next());
            }

        }

        if (iteratorList1.hasNext())
            list3.add(iteratorList1.next());
        else
            list3.add(iteratorList2.next());
        return  list3.head;

    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next = null;

        ListNode nodeA = new ListNode(4);
        ListNode nodeB= new ListNode(1);
        ListNode nodeC = new ListNode(33);
        ListNode nodeD = new ListNode(5);

        nodeA.next=nodeB;
        nodeB.next=nodeC;
        nodeC.next=nodeD;
        nodeD.next = null;

        ListNode list1 = new ListNode(3);
        ListNode list2 = new ListNode(4);

        ListNode result = mergeTwoLists( list1,list2);
    }

}
