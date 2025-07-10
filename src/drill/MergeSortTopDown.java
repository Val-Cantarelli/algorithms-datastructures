package drill;
import java.util.Arrays;

public class MergeSortTopDown {
    public static void sort(int[] array) {
        if (array.length <= 1) return;

        int mid = array.length / 2;

        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        sort(left);
        sort(right);

        merge(array, left,  right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }


    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        sort(array);
        System.out.println("Sorted array (Top-Down): " + Arrays.toString(array));
    }
}
