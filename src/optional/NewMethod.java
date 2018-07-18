package optional;

import java.util.Optional;

public class NewMethod {

  /*
   * 1. Old method
   */
  public static Double average1(int... scores) {

    if (scores == null)
      return null;

    if (scores.length == 0)
      return null;

    int sum = 0;
    for (int score : scores) {
      sum += score;
    }
    return (double) sum / scores.length;
  }

  /*
   * 2. Use optional
   */
  public static Optional<Double> average2(int... scores) {

    if (scores == null)
      return Optional.empty();

    if (scores.length == 0)
      return Optional.empty();

    int sum = 0;
    for (int score : scores) {
      sum += score;
    }
    return Optional.of((double) sum / scores.length);
  }

  /*
   * 3. ofNullable NoSuchElementException
   */
  public static Optional<Double> average3(int... scores) {
    Optional<int[]> optScores = Optional.ofNullable(scores);

    int sum = 0;

    for (int score : optScores.get()) {
      sum += score;
    }
    return Optional.of((double) sum / scores.length);
  }

  /*
   * 4. check isPresent
   */
  public static Optional<Double> average4(int... scores) {
    Optional<int[]> optScores = Optional.ofNullable(scores);

    int sum = 0;

    if (optScores.isPresent()) {
      for (int score : optScores.get()) {
        sum += score;
      }
      return Optional.of((double) sum / scores.length);

    } else {
      return Optional.empty();
    }

  }

  /*
   * 5. check orElse
   */
  public static Optional<Double> average5(int... scores) {
    Optional<int[]> optScores = Optional.ofNullable(scores);

    int sum = 0;

    for (int score : optScores.orElse(new int[0])) {
      sum += score;
    }

    // 0.0/0
    return Optional.of((double) sum / optScores.orElse(new int[0]).length);

  }

  /*
   * 6. check orElseGet
   */
  public static Optional<Double> average6(int... scores) {
    Optional<int[]> optScores = Optional.ofNullable(scores);

    int sum = 0;

    for (int score : optScores.orElseGet(() -> new int[0])) {
      sum += score;
    }
    return Optional.of((double) sum / optScores.orElseGet(() -> new int[0]).length);

  }

  /*
   * 7. check orElseThrow
   */
  public static Optional<Double> average7(int... scores) {
    Optional<int[]> optScores = Optional.ofNullable(scores);

    int sum = 0;

    for (int score : optScores.orElseThrow(() -> new RuntimeException())) {
      sum += score;
    }
    return Optional.of((double) sum / scores.length);

  }



  public static void main(String[] args) {
    System.out.println("optional avg method1(90, 100): " + average1(90, 100));
    System.out.println("optional avg method1(empty): " + average1());
    System.out.println("optional avg method1(null): " + average1(null));

    System.out.println("optional avg method2(90, 100): " + average2(90, 100));
    System.out.println("optional avg method2(empty): " + average2());
    System.out.println("optional avg method2(null): " + average2(null));

    System.out.println("optional avg method3(90, 100): " + average3(90, 100));
    System.out.println("optional avg method3(empty): " + average3());
    // System.out.println("optional avg method3(null): " + average3(null));

    System.out.println("optional avg method4(90, 100): " + average4(90, 100));
    System.out.println("optional avg method4(empty): " + average4());
    System.out.println("optional avg method4(null): " + average4(null));

    System.out.println("optional avg method5(90, 100): " + average5(90, 100));
    System.out.println("optional avg method5(empty): " + average5());
    System.out.println("optional avg method5(null): " + average5(null));

    System.out.println("optional avg method6(90, 100): " + average6(90, 100));
    System.out.println("optional avg method6(empty): " + average6());
    System.out.println("optional avg method6(null): " + average6(null));

    System.out.println("optional avg method7(90, 100): " + average7(90, 100));
    System.out.println("optional avg method7(empty): " + average7());
    System.out.println("optional avg method7(null): " + average7(null));


  }
}
