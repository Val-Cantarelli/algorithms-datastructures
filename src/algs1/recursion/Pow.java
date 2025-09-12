package algs1.recursion;
// Wrong - fix it!! Double it is not accepted. Manipulate the print
public class Pow {
    public static int pow(int a, int n){
        if(a == 0 || n == 0) return  0;
        if(n == 1) return a;
        if(n < 0){
            int numerator = 1;
            int denominator = pow(a, -n);
            //System.out.println("Result: " + numerator + "/" + denominator);
        }

        return pow(a, n-1) * a;
    }

    public static void main(String[] args) {
        int a = 2;
        int n = -2;

        System.out.println(pow(a,n));
    }
}
