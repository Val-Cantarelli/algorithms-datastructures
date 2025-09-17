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

import java.util.Arrays;

public class PlusOne {

    public int [] add(int [] arr){

        int carry = 1; // magic number
        for (int i = arr.length-1; carry != 0 && i >= 0 ; i--) {
            if(arr[i] == 9) {
                arr[i] = 0;
            }
            else{
                arr[i] = arr[i]+1;
                carry--;
            }
        }
        if(carry !=0){
            int []arrayAlt = new int[arr.length+1];
            arrayAlt[0]= 1;
            return arrayAlt;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] number = {3,4,5};
        PlusOne result = new PlusOne();
        int[] resultArray = result.add(number);
        System.out.println(Arrays.toString(resultArray));
    }
}
