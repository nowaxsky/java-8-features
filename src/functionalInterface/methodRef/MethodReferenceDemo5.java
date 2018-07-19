package functionalInterface.methodRef;

import java.util.Arrays;
import java.util.function.Supplier;
import functionalInterface.builtIn.User;

public class MethodReferenceDemo5 {

  public static void main(String args[]) {
    test1();
    test2();
    test3();
    test4();
  }

  private static void show(Object[] arr) {
    for (Object u : arr) {
      System.out.println(u.toString());
    }
    System.out.println("------------------------------------");
  }

  // Reference to a Static Method
  public static void test1() {
    User[] users = User.createArray();

    // Arrays.sort(users, (a, b) -> User.compareName(a, b));
    Arrays.sort(users, User::compareName);
    show(users);

    // Arrays.sort(users, (a, b) -> UserComparator.compareId(a, b));
    Arrays.sort(users, UserComparator::compareId);
    show(users);
  }

  // Reference to an Instance Method of a Particular Object
  public static void test2() {
    User[] users = User.createArray();

    User u = new User();

    // Arrays.sort(users, (a, b) -> u.compareAge(a, b));
    Arrays.sort(users, u::compareAge);
    show(users);

    UserComparator uc = new UserComparator();

    // Arrays.sort(users, (a, b) -> uc.compareName(a, b));
    Arrays.sort(users, uc::compareName);
    show(users);
  }

  // Reference to an Instance Method of an Arbitrary Object of a Particular Type
  public static void test3() {
    User[] users = User.createArray();

    // Arrays.sort(users, (a, b) -> a.compareNameTo(b));
    Arrays.sort(users, User::compareNameTo);
    show(users);

    // Arrays.sort(users, (a, b) -> a.compareAgeTo(b));
    Arrays.sort(users, User::compareAgeTo);
    show(users);

  }

  // Reference to constructor
  public static void test4() {

    // Supplier<MethodReferenceDemo5> supplier = () -> new MethodReferenceDemo5();
    Supplier<MethodReferenceDemo5> supplier = MethodReferenceDemo5::new;
    System.out.println(supplier.get().getClass());
  }
}
