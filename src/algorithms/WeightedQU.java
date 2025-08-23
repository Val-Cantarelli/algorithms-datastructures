package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Weighted Quick-Union with dynamic growth (resizing array) + path compression.
 */

public class WeightedQU {

    private int[] id;        // parent links
    private int[] sz;        // size by root
    private int size;        // valid nodes (0..size-1)
    private int capacity;    // id.length == sz.length

    public WeightedQU(int initialCapacity) {
        capacity = Math.max(1, initialCapacity);
        id = new int[capacity];
        sz = new int[capacity];
        size = capacity;
        for (int i = 0; i < size; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    // Grows the structure (capacity and nodes) to include the index idx, in ONE pass.
    public void growToInclude(int idx) {
        if (idx < size) return;

        // 1) ensure exponential capacity is sufficient
        int newCap = capacity;
        while (newCap <= idx) newCap *= 2;
        if (newCap != capacity) {
            id = Arrays.copyOf(id, newCap);
            sz = Arrays.copyOf(sz, newCap);
            capacity = newCap;
        }

        // 2) initialize all new nodes [size..idx]
        for (int i = size; i <= idx; i++) {
            id[i] = i;   // starts as root
            sz[i] = 1;
        }
        size = idx + 1;
    }

    // Optional API: create only 1 site (kept for compatibility)
    public int newSite() {
        growToInclude(size);
        return size - 1;
    }

    private int root(int p) {
        int r = p;
        while (r != id[r]) r = id[r];
        // full path compression from p to r
        while (p != r) {
            int np = id[p];
            id[p] = r;
            p = np;
        }
        return r;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p), j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else               { id[j] = i; sz[i] += sz[j]; }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size; i++) {
            sb.append(i).append(": ").append(id[i]);
            if (i + 1 < size) sb.append(", ");
        }
        sb.append('}');
        return sb.toString();
    }

    public int size() { return size; }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("resource/input.txt"));
        int N = scanner.nextInt();
        WeightedQU wUF = new WeightedQU(N);

        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();

            int need = Math.max(p, q);
            wUF.growToInclude(need); 

            if (!wUF.connected(p, q)) {
                wUF.union(p, q);
                System.out.println(p + " " + q);
            }
        }
        scanner.close();
        System.out.println(wUF);
    }
}
