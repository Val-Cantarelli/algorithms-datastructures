package algorithms.sorting;

import java.util.Arrays;

public class MergeSortBottomUp {
    public static void mergeSort(int[] array) {
        int n = array.length;

        // Começa com subarrays de tamanho 1 e aumenta iterativamente
        for (int width = 1; width < n; width *= 2) {
            for (int i = 0; i < n; i += 2 * width) {
                // Define os limites dos subarrays
                int mid = Math.min(i + width, n);
                int end = Math.min(i + 2 * width, n);

                // Cria os subarrays esquerdo e direito
                int[] left = Arrays.copyOfRange(array, i, mid);
                int[] right = Arrays.copyOfRange(array, mid, end);

                // Combina os subarrays no array principal
                merge(array, left, right, i);
            }
        }
    }

    private static void merge(int[] array, int[] left, int[] right, int start) {
        int i = 0, j = 0, k = start;

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
        System.out.println("Sorted array (Bottom-Up): " + Arrays.toString(array));
    }
}
