package functionalInterface.builtIn;

import java.util.function.Function;

public class FunctionType {

  public static void main(String[] args) {
    
    Function<User, String> getName = u -> u.getName();
    for (User u : User.createList()) {
      System.out.println(getName.apply(u));
    }
  }
}
