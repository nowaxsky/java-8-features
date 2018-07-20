package dateAndTimeApi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class LocalDateDemo {

  public static void main(String[] args) {
    // LocalDate don't have public constructor, do not use "new LocalDate"
    LocalDate now = LocalDate.now();
    System.out.println("Today is : " + now);

    // LocalDate.of(int year, int month, int day)
    LocalDate birthday = LocalDate.of(1995, 5, 23);
    System.out.println("Java's birthday: " + birthday);

    // LocalDate.of(int year, Month month, int day)
    LocalDate birthday2 = LocalDate.of(1995, Month.MAY, 23);
    System.out.println("Is the same? " + birthday.equals(birthday2));

    // isBefore(LocalDate)
    System.out.println("Is Java's birthday in the past? " + birthday.isBefore(now));

    // isLeapYear()
    System.out.println("Is Java's birthday in a leap year? " + birthday.isLeapYear());

    // getDayOfWeek()
    System.out.println("Java's birthday is what day of the week? " + birthday.getDayOfWeek());

    // getDayOfMonth()
    System.out.println("Java's birthday is what day of the month? " + birthday.getDayOfMonth());

    // getDayOfYear()
    System.out.println("Java's birthday is what day of the year? " + birthday.getDayOfYear());

    // plusMonths(int month)
    LocalDate nowAfterOneMonth = now.plusMonths(1);
    System.out.println("The date after 1 month: " + nowAfterOneMonth);

    // find next Monday
    LocalDate nextMonday = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    System.out.println("First Monday after now: " + nextMonday);

    // Custom Converter to String
    String localDateToString = DateUtil.localDateToString(nextMonday);
    System.out.println("LocalDate to String: " + localDateToString);

    // Custom Converter to LocalDate
    LocalDate toLoaclDate = DateUtil.toLocalDate(localDateToString);
    System.out.println("String to LocalDate: " + toLoaclDate);

  }
}
