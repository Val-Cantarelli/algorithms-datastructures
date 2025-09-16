package algs1;
import algs1.sorting.QuickSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        // Test 1: Array com elementos não ordenados
        int[] arr1 = {2, 1, 69, 33};
        int[] expected1 = {1, 2, 33, 69};
        QuickSort.quickSort(arr1);
        assertArrayEquals(expected1, arr1);

        // Test 2: Array já ordenado
        int[] arr2 = {1, 2, 33, 69};
        int[] expected2 = {1, 2, 33, 69};
        QuickSort.quickSort(arr2);
        assertArrayEquals(expected2, arr2);

        // Test 3: Array com elementos repetidos
        int[] arr3 = {5, 2, 5, 8, 1, 5};
        int[] expected3 = {1, 2, 5, 5, 5, 8};
        QuickSort.quickSort(arr3);
        assertArrayEquals(expected3, arr3);

        // Test 4: Array com um único elemento (caso base)
        int[] arr4 = {42};
        int[] expected4 = {42};
        QuickSort.quickSort(arr4);
        assertArrayEquals(expected4, arr4);

        // Test 5: Array vazio (deve retornar vazio)
        int[] arr5 = {};
        int[] expected5 = {};
        QuickSort.quickSort(arr5);
        assertArrayEquals(expected5, arr5);

        // Test 6: Array com elementos negativos
        int[] arr6 = {-5, -10, -3, 0, 2};
        int[] expected6 = {-10, -5, -3, 0, 2};
        QuickSort.quickSort(arr6);
        assertArrayEquals(expected6, arr6);
    }
}
