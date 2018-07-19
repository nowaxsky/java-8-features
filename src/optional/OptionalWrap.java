package optional;

import java.util.Optional;

public class OptionalWrap {

  /*
   * how to wrap value to optional? see following 2 methods:
   */
  public static <T> Optional<T> createOptionalMethod1(T value) {
    Optional<T> o = (value == null) ? Optional.empty() : Optional.of(value);
    return o;
  }

  public static <T> Optional<T> createOptionalMethod2(T value) {
    Optional<T> o = Optional.ofNullable(value);
    return o;
  }
}
