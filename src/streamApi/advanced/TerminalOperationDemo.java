package streamApi.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import functionalInterface.builtIn.User;

public class TerminalOperationDemo {

  public static void testCount() {

    long cnt = Stream.of("Hello", "world").count();
    System.out.println(cnt);
  }

  public static void testMaxMin() {

    // you have to use comparator to compare String
    Comparator<String> comparator = String::compareTo;

    Optional<String> os = Stream.of("x", "y").max(comparator);
    System.out.println(os);

    List<String> list = new ArrayList<>();
    Optional<String> empty = list.stream().max(comparator);
    System.out.println(empty);

    // you need to convert stream to IntStream to use min() and don't need to use comparator
    OptionalInt oi = Stream.of(1, 2, 3).mapToInt(i -> i).min();
    System.out.println(oi);

  }

  public static void testAverage() {

    OptionalDouble avg1 = Stream.of(1, 2, 3, 4).mapToInt(i -> i).average();
    OptionalDouble avg2 = Stream.of(1, 2, 3, 4).mapToLong(i -> i).average();
    OptionalDouble avg3 = Stream.of(1, 2, 3, 4).mapToDouble(i -> i).average();
    System.out.println(avg1);
    System.out.println(avg2);
    System.out.println(avg3);
    System.out.println(avg1.getAsDouble());
    System.out.println(avg2.getAsDouble());
    System.out.println(avg3.getAsDouble());

    IntStream is = Arrays.stream(new int[] {});
    OptionalDouble empty = is.average();
    System.out.println(empty);
  }

  public static void testSum() {

    // IntStream
    int iSum = Stream.of(1, 2, 3, 4).mapToInt(i -> i).sum();
    System.out.println(iSum);

    // LongStream
    long lSum = Stream.of(1, 2, 3, 4).mapToLong(i -> i).sum();
    System.out.println(lSum);

    // DoubleStream
    double dSum = Stream.of(1, 2, 3, 4).mapToDouble(i -> i).sum();
    System.out.println(dSum);

    // Empty
    int zero = IntStream.of().sum();
    System.out.println(zero);
  }

  public static void testCollect() {

    String[] sArr = new String[] {"jim1", "jim2", "jim1", "jim2"};

    Stream<String> s1 = Stream.of(sArr);
    Set<String> set = s1.collect(Collectors.toSet());
    set.stream().forEach(i -> System.out.print(i + ", "));
    System.out.println();

    Stream<String> s2 = Stream.of(sArr);
    List<String> list = s2.collect(Collectors.toList());
    list.stream().forEach(i -> System.out.print(i + ", "));

  }

  public static void testAveragingDouble() {

    Double averageAge = User.createList().stream().peek(System.out::println)

        // averagingDouble(ToDoubleFunction)
        .collect(Collectors.averagingDouble(u -> u.getAge()));
    System.out.println(averageAge);
  }

  public static void testJoining() {

    List<String> s1 = Arrays.asList("a", "b", "c", "d");

    String s1Join = s1.stream().collect(Collectors.joining());
    System.out.println(s1Join);

    String s2Join = s1.stream().collect(Collectors.joining("-"));
    System.out.println(s2Join);

    String s3Join = s1.stream().collect(Collectors.joining("-", "/*", "*/"));
    System.out.println(s3Join);
  }

  public static void testGroupingBy() {

    // use age to group by
    Function<User, Integer> classifier = u -> u.getAge();
    Map<Integer, List<User>> peopleByAge =
        User.createList().stream().collect(Collectors.groupingBy(classifier));

    peopleByAge.forEach((age, personList) -> System.out.format("age %s: %s\n", age, personList));
  }

  public static void testPartitioningBy() {

    // use age > 20 to classify the data
    Predicate<User> classifier = (u -> u.getAge() > 20);
    Map<Boolean, List<User>> peopleByAge =
        User.createList().stream().collect(Collectors.partitioningBy(classifier));
    System.out.println("Is age > 20?");
    peopleByAge.forEach((k, v) -> System.out
        .println(k + ":\t" + v.stream().map(s -> s.getName()).collect(Collectors.joining(","))));
  }

  public static void main(String[] args) {
    System.out.println("====================count");
    testCount();

    System.out.println("\n====================min max");
    testMaxMin();

    System.out.println("\n====================average");
    testAverage();

    System.out.println("\n====================sum");
    testSum();

    System.out.println("\n====================collector");
    testCollect();

    System.out.println("\n\n====================averagingDouble");
    testAveragingDouble();

    System.out.println("\n====================joining");
    testJoining();

    System.out.println("\n====================groupingBy");
    testGroupingBy();

    System.out.println("\n====================partitioningBy");
    testPartitioningBy();

  }
}
