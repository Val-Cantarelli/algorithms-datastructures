package leetCode;
// resolve espacos antes de retornar
public class ReverseWords {
    public static void reverse(char[] sentence, int start, int end){
        int m = (end - start)/2;
        int j = end;
        // First Step:
        for (int i = 0; i < m; i++){
            char temp = sentence[i];
            sentence[i] = sentence[j];
            sentence[j] = temp;
            j--;
        }
        //Second Step: aplico o mesmo, mas cada palavra do array





    }
    public static void main(String[] args) {
        String str = "  Casa pink ";
        char [] sentence = str.toCharArray();
        System.out.println(sentence);
        reverse(sentence,0, sentence.length-1);
        System.out.println(sentence);
    }

}
