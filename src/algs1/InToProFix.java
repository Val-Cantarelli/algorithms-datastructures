package algs1;
/*
Open-ended - 1.3.10 From infix to postfix
Write a program InfixToPostfix that converts an arithmetic expression from infix to postfix.
infix: 3+4*2  postFix: 3 4 2 * +

pseudocode:
while(elem in infix):
if num:
    expression += num;
else:
    while(!stack.isEmpty && operador <= stack.peek)
        expression += stack.pop
stack.push(operador)
Depois de terminar, se ainda houver operadores na pilha, eu concateno na expression
*/

import edu.princeton.cs.algs4.StdDraw;
import java.util.Stack;
public class InToProFix {
    public static String postFix(String inFix) {
        String postFixExpr = "";
        
        Stack<String> operatorsStack = new Stack<>();
        String[] arr = inFix.split(" ");

        for (int i = 0; i < arr.length; i++) {
            String elem = arr[i]; // DDefine elem correctly

            if (elem.matches("\\d+")) { // Is it a number?
                postFixExpr += elem + " ";
            } else {
                while (!operatorsStack.empty() && precedenceOperator(elem.charAt(0)) <= precedenceOperator(operatorsStack.peek().charAt(0))) {
                    postFixExpr += operatorsStack.pop() + " ";
                }
                operatorsStack.push(elem);
            }
        }
        // Pop all the operators from the stack
        while (!operatorsStack.isEmpty()) {
            postFixExpr += operatorsStack.pop() + " ";
        }

        return postFixExpr.trim();
    }
    private static int precedenceOperator(char operator){
        switch ( operator){
            case '+': case '-': return 1;
            case '*' :case '/': return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        String infix = "1 + 2 * 3 - 1 / 3";
        System.out.println(postFix(infix));
    }
}
