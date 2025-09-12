package leetCode;
/* EASY

Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.

=== Improvement ===
The improvement replaces the `HashMap` with an `int[200]`, using characters as indices.
This reduces `HashMap` overhead, improves direct access (O(1)), and saves memory,
as long as the characters are ASCII
*/


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        Set<Character> usedValues = new HashSet<>();
        char value,key;
        for (int i = 0; i < s.length(); i++){
            key = s.charAt(i);
            value=t.charAt(i);
            // If the key does not exist and actual value already exist in usedValues: false
            if(!map.containsKey(key) && usedValues.contains(value))return false;
            // If the key exist and the actual value is diferent from what we got on map: return false
            if (map.containsKey(key) && !map.get(key).equals(value)) return false;
            map.put(key, value);
            usedValues.add(value);
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s,t));
    }
}
