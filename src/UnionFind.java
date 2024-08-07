import java.lang.reflect.Array;
import java.util.ArrayList;

public class UnionFind {
    private int p;
    private  int q;

    public UnionFind(int n) {
        int[] uf = new int[n];

    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UnionFind uf = new UnionFind(N);

        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p,q)) {
                uf.union(p,q);
                System.out.println(p + " " + q);
                
            }
        }
    }

    private void union(int p, int q) {
        //add p e q no arr
    }

    private boolean connected(int p, int q) {
        return false;
        // p e q estão no array?

    }
}
