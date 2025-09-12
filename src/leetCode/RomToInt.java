package leetCode;

/* Roman to integer
We are going to use a map to search by the elements from the string;
Compare each letter with next. If letter >= nextLetter: result+=nextLetter; Else result-= nextLetter

======Optimization======
The switch-case in Java is optimized by the JVM using two strategies:
- tableswitch (super fast, O(1)) → Used when values are consecutive (e.g., 1, 2, 3...).
- lookupswitch (fast, O(log n) or O(n)) → Used when values are sparse (e.g., 3, 17, 42...).

For Roman numerals, it will likely use lookupswitch, which is more efficient than a Map
* */

public class RomToInt {
    private static int getValue(char c){
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }

    }
    public static int romanToInt(String s) {

        int result = 0;

        for(int i = 0; i < s.length(); i++){
            int letter = getValue(s.charAt(i));

            if(i < s.length() - 1 && letter < getValue(s.charAt(i+1))){
                result -= letter;

            }
            else{
                result += letter;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "MCMXCIV";
        int convertedInt = romanToInt(s);
        System.out.println(convertedInt);
    }
}
