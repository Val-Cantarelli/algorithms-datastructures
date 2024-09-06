public class LinkedStackOfStrings {

    private Node first;

    private class Node{
        private String item;
        private Node next;
    }


    public static void main(String[] args) {

        LinkedStackOfStrings stack = new LinkedStackOfStrings();

        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else System.out.print(stack.pop() + " ");
        }

    }
    public boolean isEmpty(){
        return (first==null);
    }

    private void push(String item) {
        // Insert a new node at the beginning of the list
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;



    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }
}
