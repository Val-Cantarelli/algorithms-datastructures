package leetCode;

public class LengthOfLastWord {
    public static int lengthOfTheLastWord(String s){
        //String[] arr = s.split("\\s+");
        int size = 0;
        int i = s.length()-1;
        while ( i >= 0){
              if(s.charAt(i) != ' ') {
                  size++;
                  i--;
              }
              else if (size >=1) return size;
              else {
                  size=0;
                  i--;
              }
        }
        return size;
    }
    public static void main(String[] args) {
        String s = "fly Val d ";
        System.out.println(lengthOfTheLastWord(s));
    }

}
