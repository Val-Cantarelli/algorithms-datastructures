package algorithms;

import edu.princeton.cs.algs4.StdIn;

public class StackOfStrings {
    private String[] items; // stack items
    private int n = 0; // number of items

    public StackOfStrings(int capacity)
    { items = new String[capacity];}

    public boolean isEmpty()
    { return (n ==0);}

    public void push(String item)
    { items[n++] = item; }

    public String pop()
    { return items[--n];} // --n desloca o n antes de usar. Então se encontrou "-", ele volta pro último caracter e imprimi ele e mais um espaćo
    // pois os tokens que retornam do readString não consideram espaćos em branco

    public static void main(String[] args) {
        // Create a stack of specified capacity; push strings and popo them, as directed on strandard input.

        int cap = Integer.parseInt(args[0]);
        StackOfStrings stackOfStrings = new StackOfStrings(cap);

        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")) stackOfStrings.push(item);
            else System.out.print(stackOfStrings.pop() + " ");
        }
    }


}
