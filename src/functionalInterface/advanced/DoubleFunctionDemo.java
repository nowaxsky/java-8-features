package functionalInterface.advanced;

import java.util.function.DoubleFunction;
import java.util.function.Function;

public class DoubleFunctionDemo {

  public static void main(String[] args) {

    final double PI = 3.1415926;

    // PI * 10 = ?
    Function<Double, String> calc = t -> String.valueOf(t * 10);
    String result = calc.apply(PI);
    System.out.println("New value is: " + result);


    // DoubleFunction
    DoubleFunction<String> calc2 = t -> String.valueOf(t * 100);
    String result2 = calc2.apply(PI);
    System.out.println("New value is: " + result2);
  }
}
