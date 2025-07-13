package adventsCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day72022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Map<String, Dir> content = new HashMap<>();
            String [] lineS = line.split("");

            if (lineS[1] == "cd"){
                //  faz alguma coisa
                // adiciona no path
                // ai continua lendo...
            }

            if (lineS[1] == "ls"){
                line = scanner.nextLine();
                while(true){

                }
                // le linha de baixo
                // se a linha de baixo for um commando... para
                // senao
                // se arquivo... cria arquivo
                // se diretorio cria diretorio
            }

            System.out.println(
                    content.values().stream()
                            .filter( dir -> dir.size() <= 100000)
                            .mapToInt(dir -> dir.size())
                            .sum()
            );
        }
        scanner.close();
    }
}
