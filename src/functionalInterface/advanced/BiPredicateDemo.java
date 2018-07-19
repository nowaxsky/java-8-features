package functionalInterface.advanced;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import functionalInterface.builtIn.User;

public class BiPredicateDemo {

  public static void main(String[] args) {
    List<User> users = User.createList();
    User first = users.get(0);
    System.out.println("First user: " + first.getName());

    String testName = "john";

    // TODO: Is the first John or not?
    // Predicate<User> predicate = null;
    //
    // System.out.println("Is the first John? " + predicate.test(first));

    
    
    // BiPredicate
    // BiPredicate<User, String> nameBiPred = (u, s) -> u.getName().equalsIgnoreCase(s);
    // System.out.println("Is the first John? " + nameBiPred.test(first, testName));

  }
}
