package streamApi.advanced;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import functionalInterface.builtIn.User;

public class IntermediateOperation {

  public static void createStream() {

    Stream<String> s1 = Arrays.asList("1", "2", "3", "4").stream();
    Stream<Integer> s2 = Arrays.asList(1, 2, 3, 4).stream();

    Stream<String> s3 = Stream.of("1", "2", "3", "4");
    Stream<Integer> s4 = Stream.of(1, 2, 3, 4);

    Stream<String> s5 = Arrays.stream(new String[] {"1", "2", "3", "4"});
    IntStream s6 = Arrays.stream(new int[] {1, 2, 3, 4});

    IntStream s7 = IntStream.range(0, 10);

    s1.forEach(System.out::println);
  }

  public static void testMap() {

    Function<Integer, Integer> mapper = n -> 2 * n;
    Stream<Integer> mapResult = Stream.of(1, 2, 3, 4).map(mapper);

    Object[] arr = mapResult.toArray();
    List<Object> list = Arrays.asList(arr);
    System.out.println(list);
  }

  public static void testMapTo() {

    Stream<Integer> map1 =
        Stream.of("a11", "a12", "a13").map(s -> s.substring(1)).map(s -> Integer.parseInt(s));

    ToIntFunction<String> mapper = Integer::parseInt;
    IntStream map2 = Stream.of("a11", "a12", "a13").map(s -> s.substring(1)).mapToInt(mapper);
    DoubleStream map3 =
        Stream.of("a11", "a12", "a13").map(s -> s.substring(1)).mapToDouble(Double::parseDouble);
    LongStream map4 =
        Stream.of("a11", "a12", "a13").map(s -> s.substring(1)).mapToLong(Long::parseLong);

    map1.forEach(i -> System.out.println(i));
  }

  public static void testPeek() {

    Consumer<Integer> action = System.out::println;

    Stream<Integer> stream1 = Stream.of(1, 2, 3, 4).peek(action);
    Stream<Integer> stream2 = Stream.of(5, 6, 7, 8).peek(action);

    /*
     * Streams may be lazy. Computation on the source data is performed only when the terminal
     * operation is initiated, and source elements are consumed only as needed.
     * 
     * e.g, stream1 peek is not executed, but stream2 is executed owing to toArray() method
     * 
     */
    System.out.println("length: " + stream2.toArray().length);

    Stream.of("a", "aa", "aaa", "aaaa").filter(e -> e.length() > 3)
        .peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
        .peek(e -> System.out.println("Mapped value: " + e))
        .forEach(System.out::println);
  }

  public static void testSorted() {

    List<String> list = Arrays.asList("a2", "a1", "b1", "c2", "c1");
    list.stream().sorted().forEach(s -> System.out.print(s + " "));
    
    System.out.println();
    list.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " "));

    System.out.println();
    list.stream().sorted(String::compareTo).forEach(s -> System.out.print(s + " "));

    System.out.println();
    list.stream().sorted((s1, s2) -> s2.compareTo(s1)).forEach(s -> System.out.print(s + " "));
  }

  public static void testComparing() {

    List<User> users = User.createList();

    Function<User, String> getPersonNames = User::getName;
    Function<User, Integer> getPersonAges = User::getAge;
    Comparator<User> comp = Comparator.comparing(getPersonAges).thenComparing(getPersonNames);

    users.stream().sorted(comp).forEach(s -> System.out.print(s + "\n"));
    System.out.println();
    users.stream().sorted(comp.reversed()).forEach(s -> System.out.print(s + "\n"));
  }

  public static void FlatMapDemo() {
    
    class Inner {
      String name;

      Inner(String name) {
        this.name = name;
      }

      @Override
      public String toString() {
        return this.name;
      }
    }

    class Outer {
      String name;

      public Outer(String name) {
        this.name = name;
      }

      List<Inner> inners = new ArrayList<>();

      @Override
      public String toString() {
        return this.name;
      }
    }

    List<Outer> outers = new ArrayList<>();

    // do forEach 4 times, pass 1-4 into it
    IntStream.range(1, 4).forEach(i -> outers.add(new Outer("outer_" + i)));

    // print outers
    outers.forEach(System.out::println);

    outers.forEach(outer -> IntStream.range(1, 4)
        .forEach(i -> outer.inners.add(new Inner("Inner_" + i + ", from <" + outer.name + ">"))));

    // print inners
    outers.forEach(outer -> outer.inners.forEach(System.out::println));

    System.out.println("use flatMap: ");

    long memberQuantity = outers.stream()
        // .peek(System.out::println)
        .flatMap(outer -> outer.inners.stream()).peek(System.out::println).count();
    System.out.println("# of MemberQuantity: " + memberQuantity);
  }

  public static void main(String[] args) throws IOException {

    System.out.println("====================create Stream method");
    createStream();

    System.out.println("\n====================map test");
    testMap();

    System.out.println("\n====================mapTo test");
    testMapTo();
    
    System.out.println("\n====================peek test");
    testPeek();
    
    System.out.println("\n====================sorted test");
    testSorted();
    
    System.out.println("\n\n====================comparing test");
    testComparing();
    
    System.out.println("\n====================flatMap demo");
    FlatMapDemo();

  }
}
