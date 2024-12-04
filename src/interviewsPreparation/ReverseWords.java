package interviewsPreparation;

// resolve espacos antes de retornar

public class ReverseWords {

    public static void reverse(char[] sentence, int start, int end){
        int m = (end - start)/2;
        int j = end;
        for (int i = 0; i < m; i++){
            char temp = sentence[i];
            sentence[i] = sentence[j];
            sentence[j] = temp;
            j--;
        }
    }
    public static void main(String[] args) {
        String str = "hello       world  ";
        char [] sentence = str.toCharArray();
        System.out.println(sentence);
        reverse(sentence,0, sentence.length-1);
        System.out.println(sentence);

        int startPos = 0;
        while (true){
            int start = 0;
            int end = 0;
            int i =0;
            //while (sentence[i] != ' '; i++){// quando sair daqui: teremos o start}
            start = i;
            Boolean letra = true;
            while (letra){
                i++;
                //quando sair daqui: teremos o end
            }
            end = i -1;
        }














    }

}
