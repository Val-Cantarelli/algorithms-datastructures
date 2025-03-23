package algorithms.recursion;

public class Countdown {
    public static int count(int n){
        if (n < 0) return 0;

        System.out.println(n);
        return count(n-1);
    }

    public static void main(String[] args) {
        int n= 10;
        count(n);

    }
}
