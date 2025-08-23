package AlgsPart1;
import java.util.NoSuchElementException;

public class BinaryHeap<Key extends Comparable<Key>>  {
    private  Key [] pq;
    private int N;

    // Use resizing array instead capacity by the clien
    public BinaryHeap(int capacity){
        // cast: there no generic arrys in java
        pq = (Key[]) new Comparable[capacity+1];
    }

    // heap helper function
    private void swim(int k){
        while (k > 1 && less(k/2,k)){
            // Se o filho é maior que o pai, devemos subir modificndo
            exch(k,k/2);
            k = k/2;

        }
    }
    private void sink(int k){
        // se pai é maior que filho
        while (2*k <= N){
            int j = 2*k;
            if(j < N && less(j,j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k =j;
        }
    }
    // array helper function
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j])< 0;
    }
    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    // PQ operations
    public boolean isEmpty(){
        return N == 0;
    }
    public  void insert(Key k){
        pq[++N] = k;
        swim(N);
    }
    public  Key removeMax(){
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty heap");
        }
        Key root = pq[1];
        exch(1,N--);
        sink(1);
        pq[N+1] = null; // loitering
        return root;
    }

    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>(10);
        heap.insert(5);
        heap.insert(10);
        heap.insert(3);
        System.out.println(heap.removeMax()); // Esperado: 10
        System.out.println(heap.removeMax()); // Esperado: 5
        System.out.println(heap.removeMax()); // Esperado: 3
    }
}
