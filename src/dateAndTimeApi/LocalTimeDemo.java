package dateAndTimeApi;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeDemo {

  public static void main(String[] args) {
    // LocalTime don't have public constructor, do not use "new LocalTime"
    LocalTime now = LocalTime.now();
    System.out.println("Now time is: " + now);

    // LocalTime.of(int hour, int minute)
    LocalTime lunch = LocalTime.of(12, 0);
    System.out.println("Lunch time is: " + lunch);

    // LocalTime.of(int hour, int minute, int second)
    LocalTime midnight = LocalTime.of(0, 0, 0);
    System.out.println("Midnight is: " + midnight);

    // isBefore(LocalTime)
    System.out.println("Do I miss lunch? " + lunch.isBefore(now));

    // plusHours(int hour)
    // plusMinutes(int minute)
    LocalTime nowPlus = now.plusHours(1).plusMinutes(25);
    System.out.println("The time after 1 hour 15 minutes is: " + nowPlus);

    // truncatedTo(ChronoUnit)
    LocalTime nowHrsMins = now.truncatedTo(ChronoUnit.MINUTES);
    System.out.println("Truncate the current time to minutes: " + nowHrsMins);

    // toSecondOfDay()
    System.out.println("How many seconds after midnight? " + now.toSecondOfDay());

    // LocalTime.until(LocalTime, ChronoUnit)
    long minsUntilLunch = now.until(lunch, ChronoUnit.HOURS);
    System.out.println("How many minutes are until lunch? " + minsUntilLunch);

    // LocalTime.until allows negative number
    LocalTime bedtime = LocalTime.of(0, 30);
    long hrsToBedtime = now.until(bedtime, ChronoUnit.MINUTES);
    System.out.println("How many hours are until bedtime? " + hrsToBedtime);
  }
}
