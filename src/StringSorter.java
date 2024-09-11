import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class StringSorter {
    public static void main(String[] args) {
        try {
            // Lê todas as linhas do arquivo como um array de strings
            String[] a = Files.readAllLines(Paths.get(args[0])).toArray(new String[0]);

            // Ordena as strings usando Arrays.sort (ordenação lexicográfica)
            Arrays.sort(a);

            // Imprime as strings ordenadas
            for (String str : a) {
                System.out.print(str + " ");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}