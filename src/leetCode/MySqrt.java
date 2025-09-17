package leetCode;
/* Newton-Raphson:

 * To find the square root, we want to discover where the parabola crosses the x-axis (i.e., f(x)=0).
 * Step 1: Choose an initial guess x0. This x0 has a y0 on the parabola, calculated as f(x0)=x0^2 - num.
 * Step 2: Draw the tangent line at this point (x0, y0). The tangent follows the slope of the parabola at this point,
   which is the derivative f'(x0)=2*x0.
 * Step 3: Write the equation of the line: y = a*x + b, where a = f'(x0).
 * Step 4: Find b using the tangent point: b = y0 - a*x0.
 * Step 5: To find the next guess, set y = 0 on the line and simplify: x1 = -b / a, substitute b in this equation
   and get: x1 = (y0 - a*x0) / a = x0 - y0 / a;
 * Step 6: Substitute x1 in the parabola to see if f(x1) is close to zero. If not, repeat the process using
   x1 as the new guess.
 * Step 7: Repeat until the error is sufficiently small.
 Everything just to understand:

 xnew = x0 - (f(x0)/ f'(x0))

x0 -> current guess
f(x0) -> error at that guess
f'(x0) -> slope of the curve at that point
xnew -> next guess

 */

public class MySqrt {
    public int mySqrt(int num) {
        double x = num;
        double error = 1e-6; //1×10−6

        while (Math.abs(x*x - num) > error) {
            x = x - (x*x - num) / (2*x);
        }
        return (int)x;

    }

    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(8));
    }
}
