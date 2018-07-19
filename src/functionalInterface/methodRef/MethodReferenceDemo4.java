package functionalInterface.methodRef;

import java.util.function.Function;
import java.util.function.Supplier;

/*
 * method reference by using new
 */
public class MethodReferenceDemo4 {

  String x;

  public MethodReferenceDemo4() {
    super();
  }

  public MethodReferenceDemo4(String x) {
    super();
    this.x = x;
  }

  void printX() {
    System.out.println(this.x);
  }

  private static void createObjectWithInput() {
    // Function<String, MethodReferenceDemo4> factory = s -> new MethodReferenceDemo4(s);
    Function<String, MethodReferenceDemo4> factory = MethodReferenceDemo4::new;
    MethodReferenceDemo4 demo = factory.apply("use contructor to input");
    demo.printX();
  }

  private static void createObjectWithoutInput() {
    // Supplier<MethodReferenceDemo4> supplier = () -> new MethodReferenceDemo4();
    Supplier<MethodReferenceDemo4> supplier = MethodReferenceDemo4::new;
    MethodReferenceDemo4 demo = supplier.get();
    demo.printX();
  }

  public static void main(String[] args) {
    createObjectWithInput();
    createObjectWithoutInput();
  }
}
