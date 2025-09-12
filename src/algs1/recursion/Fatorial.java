package algs1.recursion;

public class Fatorial {
    public static int factorial(int n){
        if (n == 1) return 1;
        return  factorial(n-1)  * n;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of "+ n + " = "+ factorial(n));
    }
}
