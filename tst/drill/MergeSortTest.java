package drill;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    @Test
    public void testSort() {
        // Test 1: Array com elementos não ordenados
        int[] arr1 = {38, 27, 43, 3, 3};
        int[] expected1 = {3, 3, 27, 38, 43};
        MergeSortDrill2.sort(arr1);
        assertArrayEquals(expected1, arr1);

        // Test 2: Array já ordenado
        int[] arr2 = {1, 2, 33, 69};
        int[] expected2 = {1, 2, 33, 69};
        MergeSortDrill2.sort(arr2);
        assertArrayEquals(expected2, arr2);

        // Test 3: Array com elementos repetidos
        int[] arr3 = {5, 2, 5, 8, 1, 5};
        int[] expected3 = {1, 2, 5, 5, 5, 8};
        MergeSortDrill2.sort(arr3);
        assertArrayEquals(expected3, arr3);

        // Test 4: Array com um único elemento (caso base)
        int[] arr4 = {42};
        int[] expected4 = {42};
        MergeSortDrill2.sort(arr4);
        assertArrayEquals(expected4, arr4);

        // Test 5: Array vazio (deve retornar vazio)
        int[] arr5 = {};
        int[] expected5 = {};
        MergeSortDrill2.sort(arr5);
        assertArrayEquals(expected5, arr5);

        // Test 6: Array com elementos negativos
        int[] arr6 = {-5, -10, -3, 0, 2};
        int[] expected6 = {-10, -5, -3, 0, 2};
        MergeSortDrill2.sort(arr6);
        assertArrayEquals(expected6, arr6);
    }
}
