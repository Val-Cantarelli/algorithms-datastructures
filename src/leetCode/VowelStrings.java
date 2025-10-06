package leetCode;

public class VowelStrings {
    public int vowelStrings(String[] words, int left, int right) {
        char [] vogals = {'a', 'e', 'i', 'o', 'u'};

        int count = 0;
        for( int i = left; i <= right; i++){
            boolean firstLetter = switch (words[i].charAt(0)) {
                case 'a', 'e', 'i', 'o', 'u' -> true;
                default -> false;
            };
            boolean lastletter = switch (words[i].charAt(words[i].length() - 1)) {
                case 'a', 'e', 'i', 'o', 'u' -> true;
                default -> false;
            };

            if(firstLetter && lastletter) count++;
        }
        return  count;

    }

    public static void main(String[] args) {
        String [] words = new String[]{"are", "amy", "u"};
        int left = 0;
        int right = 2;
        System.out.println(new VowelStrings().vowelStrings(words,left,right));
    }

}
