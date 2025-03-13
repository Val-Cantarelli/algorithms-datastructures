package algorithms;
/*Open-ended - Book Execise 1.3.9
Write a program that takes from standard input an expression without left parentheses and
prints the equivalent infix expression with the parentheses inserted. For example, given the input:
1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) your program should print
( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )
*/
public class FixExpression {
    public static String fixExpression(String s){

        return "";
    }

    public static void main(String[] args) {
        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        System.out.println(fixExpression(input));
    }
}
