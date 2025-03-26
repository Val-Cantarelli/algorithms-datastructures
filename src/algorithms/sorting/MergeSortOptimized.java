package algorithms.sorting;
import java.util.Arrays;
/*
MergeSort classic optimization:
Instead of copying both subarrays during the merge step, only the right half is copied to an auxiliary array.
Then, the merge is performed in reverse order: starting from the end of both the left part (in the original array)
and the right part (in the auxiliary array), moving backward while writing into the array from the end to the beginning.
This avoids overwriting elements that haven't been merged yet and reduces memory allocation.
*/
public class MergeSortOptimized {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }
    public static void sort(int[] arr, int start, int end) {
        if (end - start < 1) {
            return;}

        int middle = (start + end) / 2;

        sort(arr, start, middle);
        sort(arr, middle+1, end);

        merge(arr, start, middle, end);
    }

    public static void merge(int[] arr, int start, int middle, int end) {

        int[] aux = new int[end-middle];
        System.arraycopy(arr, middle+1, aux, 0, aux.length);

        int i = middle;
        int j = aux.length - 1;
        int k = end;


        while (i >= start && j >= 0) {
            if (arr[i] > aux[j]) {
                arr[k] = arr[i];
                i--;
            } else {
                arr[k] = aux[j];
                j--;
            }
            k--;
        }

        while (i >= start) {
            arr[k--] = arr[i--];
        }

    }
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3,3};
        sort(array);
        System.out.println("Sorted array (Top-Down): " + Arrays.toString(array));
    }
}
