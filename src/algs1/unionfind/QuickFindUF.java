package algs1.unionfind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickFindUF {
    private final int[] id;
    private int accessCount;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("val.QuickFindUF{");
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
        System.out.println(N);
        QuickFindUF uf = new QuickFindUF(N);
        while(scanner.hasNext()){
            uf.resetAccessCount();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (!uf.connectedUF(p,q)) {

                uf.union(p,q);
                System.out.println(p + "-" + q + " : "+  uf.getAccessCount() + "times");
            }
        }
        scanner.close();
        System.out.println(uf);
    }
    // Métodos para manipular o contador de acessos
    private void incrementAccessCount() {
        accessCount++;
    }
    public int getAccessCount() {
        return accessCount;
    }
    public void resetAccessCount() {
        accessCount = 0;
    }
    public void union(int p, int q) {
        // In the loop, id[p] will eventually be set to id[q], losing the reference to the original parent.
        //This will make the next elements with id[i] == id[p] to not have their values updated.
        // This is why we have pID and qID
        int pID = id[p];// find id[p]
        int qID= id[q];// find id[q]

        for (int i = 0; i < id.length; i++) {
            incrementAccessCount();
            if (id[i]==pID) {
                id[i] = qID;
                incrementAccessCount();//updating parent
            }
        }
    }
    public boolean connectedUF(int p, int q) {
        incrementAccessCount();
        incrementAccessCount();
        return (id[p] == id[q]);
    }
}

