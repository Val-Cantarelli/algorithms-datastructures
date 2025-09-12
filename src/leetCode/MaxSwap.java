package leetCode;

public class MaxSwap {
    /* Tag: medium
     * You are given an integer num. You can swap two digits at most once to
     * get the maximum valued number.Return the maximum valued
     * number you can get.
     */
    public static int[] maximumSwap(int num) {
        //By adding 1, you get the exact number of digits;
        // not just the order of magnitude.
        int n = (int)Math.log10(num) + 1;
        int []arr = new int[n];
        for(int i= arr.length-1; i >= 0; i--){
            arr[i] = num % 10;
            num = num / 10;
        }
        int index;
        for(index = 1; index < arr.length; index++) {
            if(arr[index] > arr[index -1]) break;
        }
        if (index == arr.length) return arr;
        int max = arr[index];

        for(int j = index+1; j < arr.length; j++){
            if(arr[j] >= max) {
                max = arr[j];
                index = j;
            }
        }
        //procura o menor elem que é menor que o max e swap
        for(int k = 0; k < arr.length;k++){
            if(arr[k] < max) {
                int temp = arr[k];
                arr[k] =max;
                arr[index] = temp;
                break;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        int[] arr = maximumSwap(number);
        System.out.println(number);
        for (int j : arr) System.out.print(j);
    }
}
