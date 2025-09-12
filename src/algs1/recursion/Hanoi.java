package algs1.recursion;

import java.util.Stack;

public class Hanoi {
    void move(Stack<Integer> origin, Stack<Integer> intermediate, Stack<Integer> destination, int n){
        if (n == 0) return;

        move(origin, destination,intermediate,(n-1));
        destination.push(origin.pop());
        System.out.println("moving: "+ origin+ "¨para: "+  destination + "usando: "+ intermediate);
        move(intermediate, origin, destination, n-1);
    }

    public static void main(String[] args) {
        Stack<Integer> origin = new Stack<>();
        Stack<Integer> intermediate = new Stack<>();
        Stack<Integer> destination = new Stack<>();
        for (int i = 0; i < 4 ; i++) {
            origin.push(4-i);

        }
        new Hanoi().move(origin,intermediate,destination,4);

    }
}