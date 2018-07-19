package functionalInterface.methodRef;

import java.util.Arrays;

/*
 * method reference from instance method, and reference variable is inside(String a)
 */
public class MethodReferenceDemo3 {

  public static void main(String[] args) {
    String[] arr = {"a", "B", "z", "d", "e"};

    // Arrays.sort(arr, (a,b) -> a.compareToIgnoreCase(b));
    Arrays.sort(arr, String::compareToIgnoreCase);

    for (String s : arr) {
      System.out.println(s);
    }
  }
}
