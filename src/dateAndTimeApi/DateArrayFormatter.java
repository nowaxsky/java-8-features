package dateAndTimeApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DateArrayFormatter {

  private final String[] patterns;

  public DateArrayFormatter(String... patterns) {
    this.patterns = patterns;
  }

  public LocalDate parse(String text) {
    LocalDate localDate =
        Arrays.stream(patterns).map(p -> LocalDate.parse(text, DateTimeFormatter.ofPattern(p)))
            .findFirst().orElseThrow(() -> new IllegalArgumentException(
                "Not able to parse the data for all patterns given"));
    return localDate;
  }
}
