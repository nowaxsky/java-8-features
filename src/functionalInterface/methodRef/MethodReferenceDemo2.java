package functionalInterface.methodRef;

import java.util.Arrays;

/**
 * Normal method
 * 
 * @author CPM
 *
 */
public class MethodReferenceDemo2 {

  public static void main(String[] args) {
    String[] arr = {"a", "b", "z", "d", "e"};
    UtilB u = new UtilB();

    // Arrays.sort(arr, (a,b) -> u.compare(a, b));
    Arrays.sort(arr, u::compare);

    for (String s : arr) {
      System.out.println(s);
    }
  }
}
