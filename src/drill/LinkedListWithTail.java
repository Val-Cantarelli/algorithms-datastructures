package drill;
import java.util.Iterator;
/*
The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

*/

public class LinkedListWithTail<G> implements Iterable<G>{
    Node<G> head;
    Node<G> tail;
    final Integer capacity;
    Integer counter = 0;


    public LinkedListWithTail(Integer capacity){
        this.capacity = capacity;
    }

    public void add(G elem){
        counter++;
        Node<G> node = new Node<>();
        node.value = elem;
        if(head == null){
            head = node;
            tail = head;
        }else{
            tail.next = node;
            tail = node;
            if(counter > capacity){
                head = head.next;
            }
        }



    }
    public G getTailValue() {
        return tail != null ? tail.getValue() : null;
    }
    private static class LinkedListIterator<G> implements Iterator<G>{

        private  Node<G> current;

        public LinkedListIterator(Node<G> head) {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public G next() {
            G temp = current.value;
            current = current.next;
            return temp;
        }
    }
    @Override
    public Iterator<G> iterator() {
        return new LinkedListIterator<>(head);
    }

    private static class Node<G> {
        private G value;
        Node<G> next;

        public G getValue() {
            return value;
        }
    }
}
