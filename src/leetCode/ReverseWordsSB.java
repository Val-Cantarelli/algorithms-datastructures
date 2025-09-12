package leetCode;
public class ReverseWordsSB {
    public String reverse(String sentence){
        sentence = sentence.trim().replaceAll("\\s+", " ");
        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence.append(words[i]);
            if (i != 0) {
                reversedSentence.append(" ");
            }
        }
        return reversedSentence.toString();
    }
    public static void main(String[] args) {
        String sentence = "hello       world  ";
        ReverseWordsSB reverser = new ReverseWordsSB();
        String reversed = reverser.reverse(sentence);
        System.out.println(reversed);
    }
}


