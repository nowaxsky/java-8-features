package dateAndTimeApi;

import java.time.Instant;

public class InstantDemo {

  public static void main(String[] args) throws InterruptedException {
    Instant now = Instant.now();

    // long milliseconds, int nanoseconds
    Thread.sleep(0, 1);
    Instant later = Instant.now();
    System.out.println("now is before than later? " + now.isBefore(later));

    System.out.println("  Now: " + now);
    System.out.println("Later: " + later);
    Instant epoch = Instant.parse("1970-01-01T00:00:00z");
    System.out.println("EPOCH: " + epoch);

  }
}
