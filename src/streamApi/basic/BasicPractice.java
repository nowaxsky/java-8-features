package streamApi.basic;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import functionalInterface.basic.Analyzer;
import functionalInterface.builtIn.User;

public class BasicPractice {

  public static void consumerPractice() {
    Consumer<User> printUsers = u -> u.printUser();
    // for (User u : User.createList()) {
    // printUsers.accept(u);
    // }
  }

  public static void functionPractice() {
    Function<User, String> getName = u -> u.getName();
    // for (User u : User.createList()) {
    // System.out.println(getName.apply(u));
    // }
  }

  public static void predicatePractice() {
    Predicate<User> adult = u -> u.getAge() >= 18;
    // for (User u : User.createList()) {
    // if (adult.test(u))
    // System.out.println(u);
    // }
  }

  public static void supplierPractice() {
    List<User> users = User.createList();
    List<String> ids = null;
    ids.stream().forEach(i -> System.out.println(i));
  }


  public static void main(String[] args) {
    consumerPractice();
    functionPractice();
    predicatePractice();
    supplierPractice();
  }

}
