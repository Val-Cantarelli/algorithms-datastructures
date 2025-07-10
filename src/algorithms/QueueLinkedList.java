package algorithms;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
* ITERATOR:
* Para fazer uma estrutura de dados iterável, devo incluir 'implements Iterable' na assinatura da classe,
*  o que exige que eu implemente o método iterator() dessa interface. Esse método retorna um objeto que
*  é Iterator, então preciso criar uma classe interna que implementa Iterator, sobrescrevendo (@Override)
*  seus métodos, onde eu posso passar os objetos da minha estrutura de dados. Isso permite que o cliente
*  itere instâncias da minha classe usando a instrução for-each.
*
* GENERICS:
* Use of Generics: <Item> and you just will set the type of data when you create the instance:
* "val.QueueLinkedList<Integer> queueLinkedList = new val.QueueLinkedList<>();"
*
* */

// "implements Iterable<Item>": faz val.QueueLinkedList iterável para o cliente usar
// sem a necessidade de conhecer a implementacão da minha queue.
public class QueueLinkedList<Item> implements Iterable<Item> {

    private Node first;
    private Node last;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){return (first==null);}

    public void enqueue(Item item){
        // New node at the end

        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty())first = last;
        else oldlast.next = last;
    }
    public Item dequeue(){
        // Remove the first node
        Item item= first.item;
        first = first.next;
        if(isEmpty()) last=null;
        return item;
    }

    // Preciso implementar o iterator() para retornar um Iterator<Item>
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    // É uma inner class que (precisa ser feita aqui dentro - melhor acesso aos dados) implementa
    // Iterator sobrescrevendo os métodos da instancia para interagir com os objetos da minha classe.
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        // Metodo opcional - não indicado usar!
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {



        Stack<Integer> stack = new Stack<Integer>();
        int N = 50;
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) StdOut.print(d);
        StdOut.println();
        // Test client pode iterar pelo for-each statement(sugar syntax)

        QueueLinkedList<String> queueLinkedList = new QueueLinkedList<>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")) queueLinkedList.enqueue(item);
            else System.out.print(queueLinkedList.dequeue() + " ");


        //for (String q:queueLinkedList)System.out.println(q);
        }
    }
}
