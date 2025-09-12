package leetCode;

import java.util.HashSet;
import java.util.Set;

/*EASY
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the
squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops
endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

*/
public class HappyNumber {
    public static boolean isHappy(int n){
        // Enquanto n != 1
        // n está no set?
        //     Sim: return false
        //     não:
        //         add ao set
        //         calcule a soma dos quadrados de todos os algoritmos de n (result)
        //         atualize o valor de n para result
        Set<Integer> set = new HashSet<>();
        while (n != 1){
            if(set.contains(n)) return  false;
            set.add(n);

            // calculo a soma de todos os quadrados dos algarismos que compoem o n
            int result = 0;
            int digito = 0;
            while (n > 0){
                digito = n % 10;
                n = n/10;
                result += digito * digito;
            }

            n = result;
        }
        return  true;
    }
    public static void main(String[] args) {
        int n = 1;
        System.out.println(isHappy(n));
    }
}
