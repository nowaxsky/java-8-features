package functionalInterface.builtIn;

import java.util.function.Consumer;

public class ConsumerType {

  public static void main(String[] args) {

    Consumer<User> printUsers = u -> u.printUser();
    for (User u : User.createList()) {
      printUsers.accept(u);
    }
  }

}
