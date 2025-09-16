package algs1.trees;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.StdIn;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BinarySearch {

    public static  int rank(int key,int[] a){
        int lo = 0;
        int hi = a.length-1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid +1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> whitelistList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextInt()) {
                whitelistList.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + args[0]);
            return;
        }
        int[] whitelist = whitelistList.stream().mapToInt(i -> i).toArray();
        Arrays.sort(whitelist);

        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if(rank(key,whitelist) ==-1)
                System.out.println(key);
        }
    }
}
