package AlgsPart1.priorityQueue;

public class BinaryHeap<Key extends Comparable<Key>>  {


    public static int swim(int k){
        while (k > 1 && less(k,k/2)){
        }
    }

    private void sink(int k){
        // scenario: parent becames smaller than children
    }

    private static int less(int k, int i) {
        return Math.min(k,i);
    }

    public  void insert(){
        pq[++N] = x;

        swim(N);
    }

    public  void remove(Key x){
        // exch first with last
        // cll sink mathod
    }

    public static void main(String[] args) {

    }
}
