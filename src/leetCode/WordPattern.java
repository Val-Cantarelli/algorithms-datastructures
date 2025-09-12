package leetCode;
/* EASY
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern
 and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.


*/


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        String [] str = s.split(" ");
        if(pattern.length() != str.length) return false;



        Set<String> usedValues = new HashSet<>();
        char key;
        String value;
        for (int i = 0;i < pattern.length(); i++){
            key = pattern.charAt(i);
            value = str[i];
            if(map.containsKey(key) && !map.get(key).equals(value)) return false;
            if(!map.containsKey(key) && usedValues.contains(value))return false;
            map.put(key,value);
            usedValues.add(value);
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "aaa";
        String s = "aa aa aa ";
        System.out.println(wordPattern(pattern,s));
    }
}
