//Chloe Cho
import java.util.*;
public class PolynomialSolver
{
   public static double evaluatePolynomial(double[] coefficients, double x) {
      double result = 0.0;
      for (int i = 0; i < coefficients.length; i++) {
         result += coefficients[i] * Math.pow(x, i);
      }
      return result;
   }

   public static double findRoot(double[] coefficients, double a, double b) {
      double c = (a + b) / 2;
      double fc = evaluatePolynomial(coefficients, c);
      if (Math.abs(fc) < 0.000001) {
         return c;
      }
      if (evaluatePolynomial(coefficients, a) * fc < 0) {
         return findRoot(coefficients, a, c);
      } else {
         return findRoot(coefficients, c, b);
      }
   }
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
   
      System.out.print("Enter the degree of the polynomial: ");
      int degree = scanner.nextInt();
   
      double[] coefficients = new double[degree+1];
      for (int i = 0; i <= degree; i++) {
         System.out.print("Enter the coefficient of x^" + i + ": ");
         coefficients[i] = scanner.nextDouble();
      }
   
      double root = findRoot(coefficients, -10000, 10000);
      if (Math.abs(Math.round(root) - root) < 0.000001) {
         System.out.println("Root: " + Math.round(root));
      } else {
         System.out.println("Root: Almost 0");
      }
   }
}
