package dateAndTimeApi;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;

public class FluentDemo {

  public static void main(String[] args) {
    LocalDate myDay0 = LocalDate.of(1977, 6, 11);
    LocalDate myDay1 = Year.of(1977).atMonth(06).atDay(11);

    LocalDate myDay2 = myDay0.plus(Duration.ofHours(24)).plusDays(5);

    LocalDateTime meeting = LocalDate.of(2016, 07, 10).atTime(11, 30);

    Instant instant = Instant.now().plus(Duration.ofHours(24)).plus(Period.ofDays(5))
        .minus(Duration.ofMinutes(3));
    System.out.println(instant);
  }
}
