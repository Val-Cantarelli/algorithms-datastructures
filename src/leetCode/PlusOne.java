package leetCode;

/*
 * Strategies considered:
 * 1. int -> String -> int: works, but involves too much conversion/manipulation.
 * 2. Carry propagation (chosen): propagate state across digits, digit by digit.
 *
 * Data structure:
 * - Worst case: [9,9,...,9] requires allocating a new array of length()+1.(but it will not pass in the LeetCode test)
 * - Alternative: List + reverse(). Easier to implement, but less efficient.
 * - Decision: stick with array, since the "all 9s" pattern is rare and the cost
 *   of rewriting is acceptable when it happens.
 */

public class PlusOne {

    public int [] add(int [] arr){
        int carry = 0;
        int[] array = new int [arr.length];

        for (int i = arr.length; i >= 0 ; i--) {
            if(arr[i] == 9) {
                arr[i] = 0;
                carry++;
            }

        }



        return array;
    }

    public static void main(String[] args) {
        int[] number = {1,2,4};
        int [] result = new PlusOne().add(number);
        for (int elem:result) {System.out.print(elem);}
    }
}
