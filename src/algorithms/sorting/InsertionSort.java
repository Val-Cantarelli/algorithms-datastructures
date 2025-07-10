package algorithms.sorting;
import java.util.Scanner;

public class InsertionSort {
    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 ; j--) {
                if(a[j].compareTo(a[j-1])<0) exchange(a, j-1, j);

            }

        }
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[j];
        a[j] = a[i];
        a[i]= temp;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] stringArray = line.split("\\s+");
       //String [] a = StdIn.readAllStrings();
       Integer [] intArray = new Integer [stringArray.length];
        for (int i = 0; i <stringArray.length ; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        sort(intArray);

        for (int i = 0; i <intArray.length ; i++) {
            System.out.print(intArray[i]+ " ");
        }
        System.out.println();
    }
}
