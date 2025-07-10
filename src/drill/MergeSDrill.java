package drill;

import java.util.Arrays;

public class MergeSDrill {
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3,3};
        sort(array);
        System.out.println("Sorted array (Top-Down): " + Arrays.toString(array));
    }
    private static void sort(int[] array) {
        sort(array,0,array.length-1);
    }

    private static void sort(int[] array, int start, int end) {
        // Case base
        if(end - start < 1) return;
        int middle = ((end - start)/2) + start; // bug of MaxInteger from length method

        sort(array,start,middle);
        sort(array,middle+1, end);
        mergeS(array,start,middle,end);
    }

    private static void mergeS(int[] array, int start, int middle, int end) {
        //copia right to aux
        int [] aux = new int[end - middle];
        System.arraycopy(array, middle+1, aux, 0, aux.length);

        int i = middle;
        int j = aux.length-1;
        int k = end;

        while (j >= 0 && i >= start){
            if(array[i] < aux[j])array[k--] = aux[j--];
            else array[k--] = array[i--];
        }

        while (j >= 0){
            array[k--] = aux[j--];
        }

    }
}
