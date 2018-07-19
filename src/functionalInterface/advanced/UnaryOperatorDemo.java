package functionalInterface.advanced;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import functionalInterface.builtIn.User;

public class UnaryOperatorDemo {

  public static void main(String[] args) {
    List<User> users = User.createList();
    User first = users.get(0);

    // TODO: convert to upper case
    // Function<String, String> function = null;
    // System.out.println("Before: " + first.getName());
    // System.out.println("After: " + function.apply(first.getName()));



    // UnaryOperator
    // UnaryOperator<String> unaryStr = s -> s.toUpperCase();
    // System.out.println("Before: " + first.getName());
    // System.out.println("After: " + unaryStr.apply(first.getName()));

  }
}
