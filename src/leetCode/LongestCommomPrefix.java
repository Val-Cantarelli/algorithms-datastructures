package leetCode;
/*
I take the first word as the reference prefix.
If a match is found, I check for the common substring and reduce the prefix if necessary.
If, after reducing, no common prefix is found, I return an empty string (all words must share the same prefix).

==== Optimization ====
If there are many words, it might be worth sorting the array first, which costs O(n log n).
*/

public class LongestCommomPrefix {
    public static String longestCommomPrefix(String [] words){
        String prefix = words[0];
        for (int i = 1; i < words.length; i++) {
            int j = 0;
            while( j < prefix.length() && j < words[i].length() && prefix.charAt(j) == words[i].charAt(j)) {
                j++;
            }
            prefix = prefix.substring(0,j);
        }
        if (prefix.isEmpty()) {
            return "";
        }
        return prefix;
    }

    public static void main(String[] args) {
        String [] test = new String[]{"oi","val"}; //"casa","casaco","casei" , "flower","flow","flight"
        System.out.println(longestCommomPrefix(test));

    }
}
