package algorithms.sorting;
import java.util.Arrays;

public class MergeSortTopDown {
    public static void mergeSort(int[] array) {
        if (array.length <= 1) return;

        int mid = array.length / 2;

        // Divide o array em duas partes
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        // Ordena recursivamente as duas metades
        mergeSort(left);
        mergeSort(right);

        // Combina as duas metades ordenadas
        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Combina os elementos dos subarrays em ordem
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Adiciona os elementos restantes de cada subarray
        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(array);
        System.out.println("Sorted array (Top-Down): " + Arrays.toString(array));
    }
}
