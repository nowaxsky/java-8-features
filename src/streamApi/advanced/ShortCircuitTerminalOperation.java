package streamApi.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ShortCircuitTerminalOperation {

  public static void testAllMatch() {

    List<String> list = Arrays.asList("jim1", "jim2", "jim3", "jim4");
    List<String> empty = new ArrayList<>();

    boolean containsJim = list.stream().allMatch(p -> p.contains("jim"));
    boolean contains1 = list.stream().allMatch(p -> p.contains("1"));

    // if Stream is empty, allMatch do not execute the Predicate and return true
    boolean emptyStream = empty.stream().allMatch(p -> p.contains("1"));

    System.out.println("all string contain jim:\t" + containsJim);
    System.out.println("all string contain 1:\t" + contains1);
    System.out.println("if stream is empty then always return:\t" + emptyStream);
  }

  public static void testNoneMatch() {

    List<String> list = Arrays.asList("jim1", "jim2", "jim3", "jim4");
    List<String> empty = new ArrayList<>();

    boolean contains5 = list.stream().noneMatch(p -> p.contains("5"));

    // if Stream is empty, allMatch do not execute the Predicate and return true
    boolean emptyStream = empty.stream().noneMatch(p -> p.contains("1"));

    System.out.println("all string not contain 5:\t" + contains5);
    System.out.println("if stream is empty then always return:\t" + emptyStream);
  }

  public static void testAnyMatch() {

    List<String> empty = new ArrayList<>();

    boolean lengthOver5 = Stream.of("two", "three", "eighteen").anyMatch(s -> s.length() > 5);

    // if Stream is empty, anyMatch do not execute the Predicate and return true
    boolean emptyStream = empty.stream().noneMatch(p -> p.contains("1"));

    System.out.println("any string's length > 5:\t" + lengthOver5);
    System.out.println("if stream is empty then always return:\t" + emptyStream);
  }

  public static void testFindFirst() {
    List<String> empty = new ArrayList<>();

    Optional<String> val = Stream.of("one", "two").findFirst();
    Optional<String> emptyStream = empty.stream().findFirst();

    System.out.println(val);
    System.out.println(emptyStream);
  }

  public static void testFindAny() {

    List<String> list = Arrays.asList("jim1", "jim2", "jim3", "jim4");
    List<String> empty = new ArrayList<>();

    Optional<String> val = list.stream().findAny();
    Optional<String> emptyStream = empty.stream().findAny();

    System.out.println(val);
    System.out.println(emptyStream);
  }

  public static void main(String[] args) {
    System.out.println("\n====================allMatch");
    testAllMatch();
    
    System.out.println("\n====================noneMatch");
    testNoneMatch();
    
    System.out.println("\n====================anyMatch");
    testAnyMatch();
    
    System.out.println("\n====================findFirst");
    testFindFirst();
    
    System.out.println("\n====================findAny");
    testFindAny();

  }
}
