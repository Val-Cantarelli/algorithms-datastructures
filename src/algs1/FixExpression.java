package algs1;

import java.util.Stack;

/*Open-ended - Book Execise 1.3.9
Write a program that takes from standard input an expression without left parentheses and
prints the equivalent infix expression with the parentheses inserted. For example, given the input:
1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) your program should print

( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )
*/
public class FixExpression {
    public static String fixExpress(String expression) {

        Stack<String> operand = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (String elem  : expression.split(" ")) {

            if (elem.matches("\\d+")) {
                operand.push(elem );
            } else if ("+-*/".contains(elem) ) {
                operators.push(elem);
            } else if (elem.equals(")")) {
                String right = operand.pop();
                String left = operand.pop();
                String operator = operators.pop();
                String novaExpress;
                novaExpress = "( " + left + " " + operator + " " + right + " )";
                operand.push(novaExpress);
            }
        }

        return operand.pop();
    }

    public static void main(String[] args) {
        String exp = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        System.out.println(fixExpress(exp));
    }
}

