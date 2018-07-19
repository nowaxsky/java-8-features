package functionalInterface.advanced;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

import functionalInterface.builtIn.User;

public class ToDoubleFunctionDemo {

  public static void main(String[] args) {

    List<User> users = User.createList();
    User first = users.get(0);

    // TODO: convert age to double
    // Function<User, Double> convertAgeToDouble = null;
    // System.out.println(convertAgeToDouble.apply(first));



    // ToDoubleFunction
    // ToDoubleFunction<User> convertAgeToDouble2 = u -> u.getAge();
    // System.out.println(convertAgeToDouble2.applyAsDouble(first));

  }
}
