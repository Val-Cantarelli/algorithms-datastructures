package algorithms.sorting;

public class QuickSort {
     /* Divide the array into two parts (logically, not physically).
     Select a pivot and place it in the first position.
     Use two pointers, i and j, i++ e j--.
     While arr[i] is less than pivot, increment i.
     While arr[j] is greater than pivot, decrement j.
     When you have arr[i] > pivot and arr[j] < pivot, swap arr[i] and arr[j].

     Remember: i and j should cross over. Once they do, j will be in the correct position to place the pivot (arr[lo]).
     Swap arr[lo] with arr[j] to finalize the pivot's position.
     Now, apply the same logic recursively to the left and right subarrays.
     Left: from 0 to j.
     Right: from j + 1 to arr.length - 1.
     */

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int indexPivot = (start + end) / 2;
        int pivot = arr[indexPivot];

        arr[indexPivot] = arr[start];
        arr[start] = pivot;

        int i = start + 1;
        int j = end;

        while (true) {
            while (i <= end && arr[i] <= pivot) i++;
            while (j>= start && arr[j] > pivot) j--;

            if (i >= j) break;

            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j] = temp;
        }
        arr[start] = arr[j];
        arr[j] = pivot;
        quickSort(arr, start, j-1); //
        quickSort(arr, j+1, end);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 5, 8, 1, 5};
        quickSort(arr);
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }
}
