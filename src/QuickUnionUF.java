import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickUnionUF {
    private final int[] id;

    public QuickUnionUF(int N){
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] =i;
    }

    private  int root(int i){
        while (i != id[i])i=id[i];
       return i;
    }

    // check if p and q have the same root
    public boolean connected(int p,int q){
        return root(p)==root(q);
    }

    // Change root of p to point to root of q
    public void union(int p,int q){
        int i= root(p);
        int j = root(q);
        id[i] = j;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/input.txt"));
        int N = scanner.nextInt();
        System.out.println(N);

        QuickUnionUF uf = new QuickUnionUF(N);

        while (scanner.hasNext()){
            int p = scanner.nextInt();
            int q = scanner.nextInt();

            if (!uf.connected(p,q)) {
                uf.union(p,q);
                System.out.println(p + " "+ q);
            }
        }
        scanner.close();
    }


}

