package leetCode;
/*
Procure a primeira letra de needle;
Pegue em haystack o range que corresponde a needle e teste se são iguais
Retorne o index do início do range
*
* n input test case is incorrect, causing the code to fail.

Improvement:
Given:
needle = "abcdefg"
haystack = "abcdefabcdefabcdefabcdefabcdefabcdefabcdefg"

First iteration: "abcdefg" != "abcdef".
Second iteration: I continue from 'b' at index 1, even though I
could have used the length of this mismatch to jump directly to the next 'a'.
See: Knuth-Morris-Pratt (KMP)

* */
public class FirstOccur {
    public static int strStr(String haystack, String needle) {
        if(needle.length() <= haystack.length()) {
            for (int i = 0; i < haystack.length(); i++) {
                if(needle.charAt(0) == haystack.charAt(i) && needle.equals(haystack.substring(i,i+needle.length()))) return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String needle = "issippi";
        String haystack = "mississippi";
        System.out.println(strStr(haystack,needle));
    }
}
