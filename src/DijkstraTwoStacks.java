import edu.princeton.cs.algs4.StdIn;
import java.util.Stack;

public class DijkstraTwoStacks {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> values = new Stack<>();

        while (!StdIn.isEmpty()){
            String s = StdIn.readString();
            if (s.equals("("));
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals(")")) {
                // pega  operando e um operador, faz calculo e push no values
                String op = ops.pop();
                if (op.equals("+")) values.push( values.pop()+values.pop());
                else if (op.equals("*")) values.push( values.pop()*values.pop());
            }
           else values.push(Double.parseDouble(s));
        }
        System.out.println(values.pop());
    }
}
