package optional;

public class OldMethod {

  // old method, you have to handle arg is null,
  // but if this method return null, cannot use it easily, see testNull method
  public static Double average(int... scores) {
    if (scores.length == 0)
      return null;

    int sum = 0;
    for (int score : scores) {
      sum += score;
    }
    return (double) sum / scores.length;
  }

  public static void testNull() {
    char[] str = {'D', 'u', 'k', 'e'};
    String s = null;
    for (char c : str) {
      s += c;
    }

    // null string can add other string
    System.out.print("when null string is added: ");
    System.out.println(s);

    Object o = null;

    // null object can be printed
    System.out.print("when null object is printed: ");
    System.out.println(o);
    // System.out.println(null); //compile error
  }

  public static void main(String[] args) {
    System.out.println("old avg method(90, 100): " + average(90, 100));
    System.out.println("old avg method(null): " + average());

    testNull();

  }
}
