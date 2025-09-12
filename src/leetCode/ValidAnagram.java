package leetCode;

/* EASY
I first tried using an array to count frequencies, but started having problems tracking if I had used
all the letters from 's' at the same frequency.
So, in that case—without using a HashMap because we only have 26 letters—we are going to use a frequency
array. We'll increment and decrement simultaneously, and in the end, check if all the 26 positions are equal to 0.
*/
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int [] freq = new int[26];
        int letterS, letterT;
        for(int i =0; i < s.length(); i++){
            letterS = s.charAt(i) - 97;
            letterT = t.charAt(i) - 97;
            freq[letterS]+=1;
            freq[letterT]-=1;
        }

        for (int j = 0; j < freq.length; j++) {
            if (freq[j] != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
    String s= "ab";
    String t= "a";
    System.out.println(isAnagram(s,t));
    }
}
