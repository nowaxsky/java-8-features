package exception.wrapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamExceptionDemo {

  public static void main(String[] args) {

    List<Integer> ints = IntStream.range(0, 10).boxed().collect(Collectors.toList());
    // ints.stream().map(Util::doubleTimes).forEach(System.out::println);

    // ints.stream()
    // .map(StreamExceptionWrapper.handlingFunctionWrapper(Util::doubleTimes, Exception.class))
    // .forEach(System.out::println);
  }
}
