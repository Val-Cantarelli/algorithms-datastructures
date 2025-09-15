package drill;

public class FirstOccur {
    public static void main(String[] args) {
        String x = "leetcode";
        String y = "leeto";
        System.out.println(firstOccur(x,y));
    }

    private static int firstOccur(String x, String y) {
        int i = 0;
        while(i <= x.length() - y.length()){
            if(x.charAt(i) == y.charAt(0)){
                String subCheck = x.substring(i, i + y.length());
                if(subCheck.equals(y)){
                    return i;
                }
            }i++;
        }
        return -1;
    }
}
