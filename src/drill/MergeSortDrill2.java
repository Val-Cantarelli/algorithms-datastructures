package drill;

public class MergeSortDrill2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 33, 69};
        sort(array);
        for(int elem:array)System.out.print(elem + " ");
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length-1);
    }
    private static void sort(int[] array, int start, int end) {
        // Case base: array length < 1
        if(end - start < 1)return;

        int middle = ((end - start)/2) + start;
        sort(array, start,middle);
        sort(array,middle+1, end);

        merge(array,start,middle,end);
    }

    private static void merge(int[] array, int start, int middle, int end) {
        // Criar o vetor aux com a parte direita do array
        int [] aux = new int[end-middle];
        System.arraycopy(array,middle+1,aux,0,aux.length);
        int i = middle;
        int j = aux.length-1;
        int k = end;
        while (i >= start && j >= 0 ){
            if(array[i] <= aux[j]) array[k--] = aux[j--];
            else{array[k--] = array[i--];}
        }
        while(j >= 0){
            array[k--] = aux[j--];
        }
    }
}
