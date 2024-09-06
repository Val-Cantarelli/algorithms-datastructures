import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeightedQU {
    /**
     This class is similar to the QuickUnionUF, but with weight
     system applied to make sure the tree will not be tall and skinny

     Modifications:
     - Link root of smaller tree to root a larger tree;
     -  Update the sz[] array.
     - Path compression

     */
    private final int[] id;
    private final int[] sz;

    public WeightedQU(int N){
        id = new int[N];
        this.sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] =i;
            sz[i] = 1;
        }
    }
    private  int root(int p){
        int root = p;
        // Find the root of p
        while (root != id[root])root = id[root];

        // Total compression: all the nodes on the path of p, will point to the root
        while (p != root){
            int newp = id[p];
            id[p] = root;
            p = newp;
        }
        return root;
    }



//    private int root(int p){
//        if (id[p] != p) {
//            int root = root(id[p]);
//            id[p] = root;
//        }
//        return id[p];
//    }

    public boolean connected(int p,int q){
        return root(p)==root(q);
    }

    public void union(int p,int q){
        int i= root(p);
        int j = root(q);
        if (sz[i]<sz[j]){id[i] = j;sz[j]+=sz[i];}
        else{id[j] = i;sz[i]+=sz[j]; }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < id.length; i++) {
            sb.append(i).append(": ").append(id[i]).append(", ");
        }
        if (id.length > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/input.txt"));
        int N = scanner.nextInt();
        WeightedQU wUF = new WeightedQU(N);

        while(scanner.hasNext()){
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (!wUF.connected(p,q)) {
                wUF.union(p,q);
                System.out.println(p + " " + q);
            }
        }
        scanner.close();
        System.out.println(wUF);
    }
}
