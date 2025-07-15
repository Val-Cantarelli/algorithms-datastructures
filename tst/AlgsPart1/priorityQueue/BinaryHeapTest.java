package AlgsPart1.priorityQueue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BinaryHeapTest {

    @Test
    public void testInsertAndRemoveMax() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(10);
        heap.insert(4);
        heap.insert(8);
        heap.insert(1);
        heap.insert(6);

        assertEquals(8, heap.removeMax());
        assertEquals(6, heap.removeMax());
        assertEquals(4, heap.removeMax());
        assertEquals(1, heap.removeMax());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testSingleElement() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(1);
        heap.insert(42);
        assertEquals(42, heap.removeMax());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testIsEmptyInitially() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(5);
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testOrderPreserved() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(10);
        int[] input = {7, 3, 5, 9, 1};
        for (int val : input) heap.insert(val);

        int[] expected = {9, 7, 5, 3, 1};
        for (int val : expected) {
            assertEquals(val, heap.removeMax());
        }
    }

    @Test
    public void testThrowOnRemoveFromEmpty() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(3);
        assertThrows(NoSuchElementException.class, heap::removeMax);
    }
}
