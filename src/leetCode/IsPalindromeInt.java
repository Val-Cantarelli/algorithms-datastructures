package leetCode;

public class IsPalindromeInt {
    public boolean palindromeInt(int x){
        String s = Integer.toString(x);
        int i = 0;
        int j = s.length()-1;

        while (i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 121;

        System.out.println(new IsPalindromeInt().palindromeInt(x));
    }
}
