package exception.wrapper;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StreamExceptionWrapper {

  public static <T, E extends Exception> Consumer<T> handlingConsumerWrapper(
      ThrowingConsumer<T, E> throwingConsumer, Class<E> exceptionClass) {
    return i -> {
      try {
        throwingConsumer.accept(i);
      } catch (Exception e) {
        throw new RuntimeException();
      }
    };

  }

  public static <T, R, E extends Exception> Function<T, R> handlingFunctionWrapper(
      ThrowingFunction<T, R, E> throwingFunction, Class<E> exceptionClass) {
    return i -> {
      try {
        return throwingFunction.apply(i);
      } catch (Exception e) {
        throw new RuntimeException();
      }
    };
  }

  // practice
  public static <T, E extends Exception> Predicate<T> handlingPredicateWrapper(
      ThrowingPredicate<T, E> throwingPredicate, Class<E> exceptionClass) {
    return null;
  }

  // practice
  public static <T, E extends Exception> Supplier<T> handlingSupplierWrapper(
      ThrowingSupplier<T, E> throwingSupplier, Class<E> exceptionClass) {
    return null;
  }
}
