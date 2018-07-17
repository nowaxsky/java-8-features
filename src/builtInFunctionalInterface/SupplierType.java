package builtInFunctionalInterface;

import java.util.function.Supplier;

public class SupplierType {

  public static void main(String[] args) {
    
    Supplier<User> user = () -> new User("B04", "Eason", 28);
    System.out.println(user.get());
  }

}
