package functionalInterface.builtIn;

import java.util.function.Predicate;

public class PredicateType {

  public static void main(String[] args) {
    
    Predicate<User> adult = u -> u.getAge() >= 18;
    for (User u : User.createList()) {
      if (adult.test(u))
        System.out.println(u);
    }

  }
}
