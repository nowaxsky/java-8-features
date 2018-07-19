package functionalInterface.methodRef;

import java.util.Arrays;

/**
 * Static method
 * 
 * @author CPM
 *
 */
public class MethodReferenceDemo {

  public static void main(String[] args) {
    String[] arr = {"a", "b", "z", "d", "e"};
    // Arrays.sort(arr, (a,b) -> UtilA.compareIgnoreCase(a, b));
    Arrays.sort(arr, UtilA::compareIgnoreCase);

    for (String s : arr) {
      System.out.println(s);
    }
  }
}
